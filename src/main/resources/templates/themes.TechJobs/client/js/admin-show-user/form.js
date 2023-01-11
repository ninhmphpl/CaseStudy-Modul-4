checkOtherAdminBack()
function form(id , name, role, status) {
    return ` <div class="job pagi">
              <div class="job-content">
                <div class="job-logo">
                  <span>
                    <img src="../img/fpt-logo.png" class="job-logo-ima" alt="job-logo">
                  </span>
                </div>

                <div class="job-desc">
                  <div class="job-title">
                    <span>${name}</span>
                  </div>
                  <div class="job-company">
                    <span href="">${role}</span>
                  </div>
                  <div class="job-company">
                    Trạng thái: ${statusRender(getID(status))}
                  </div>
                </div>
                <div class="wrap-btn-appl">
                  <select onchange="changeStatus(${id})" id="statusUser${id}">
                    <option value="1" ${getID(status)==1?"selected":""}>Mở Tài Khoản</option>
                    <option value="2" ${getID(status)==2?"selected":""}>Khoá Tài Khoản</option>
                    <option value="3" ${getID(status)==3?"selected":""}>Xét Duyệt</option>
                  </select>
                </div>
              </div>
            </div>`
}
function statusRender(statusId){
    switch (statusId){
        case 1:
            return "Đang mở"
        case 2:
            return "Đang khoá"
        case 3:
            return "Chờ Duyệt"
    }
}
function renderForm() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json',
            Authorization : getToken()
        },
        type: "GET",
        url: "http://localhost:8080/admUser",
        success: function (data) {
            let content = ""
            for (let i = 0; i < data.length; i++) {
                let email = data[i].email
                let role = data[i].role
                let status = data[i].status
                let id = data[i].id
                content += form(id, email, displayRole(role.id), status)
                document.getElementById("findAll").innerHTML = content;
            }
        }
    })
}

function displayRole(id) {
    switch (id) {
        case 1:
            return "admin"
        case 2:
            return "customer"
        case 3:
            return "company"
    }
}
function changeStatus(id){
    let status = +document.getElementById("statusUser"+id).value
    let url ="http://localhost:8080/userDisable/" + id + "/" + status
    $.ajax({
        headers: {
            Authorization: getToken()
        },
        type: "PUT",
        url: url,
        success: function () {
            renderForm()
            alert(status.name + "Thành Công!")
        }
    })
}
function blockUser(id) {
    Swal.fire({
        title: 'Block User',
        text: "Are you sure to want to block this user ?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#d33',
        cancelButtonColor: '#7c7c7c',
        confirmButtonText: 'Block'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                'Blocked!',
                'User is blocked.',
                'success'
            )
            let Status = 0;
            let UserStatus = {
                id: id,
                status: Status
            }
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    Authorization: getToken()
                },
                type: "PUT",
                url: "http://localhost:8080/userDisable/id=" + id + "&status=" + Status,
                data: JSON.stringify(UserStatus),
                success: function () {
                    getAllActiveUsers()
                    getAllBlockedUsers()
                    getAllPendingUsers()
                }
            })
            event.preventDefault();
        }
    })
}
renderForm()
blockUser(id)
// activeUser(id)
