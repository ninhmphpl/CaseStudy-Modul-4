let tokens = getToken()
renderForm()
checkOtherAdminBack()

function searchByName(){
    let search = document.getElementById("searchByName").value
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json',
            Authorization : getToken()
        },
        type: "GET",
        url: "http://localhost:8080/admOffer/search?search=" + search,
        success: function (data) {
            let content = ""
            for (let i = 0; i < data.length; i++) {
                let career = data[i].career
                let description = data[i].description
                let city = data[i].city
                let amount = data[i].amount
                let endDate = data[i].endDate
                let name = data[i].name
                let status = data[i].status
                let id = data[i].id
                // (id , name, description,career, endDate , city, amount,workExperience,skill, status,company)
                content += form(id, name ,description, career , endDate , city , amount , status )
                document.getElementById("findAll").innerHTML = content;
            }
        }
    })
}
function searchByCityName(){
    let search = document.getElementById("searchByCityName").value
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json',
            Authorization : getToken()
        },
        type: "GET",
        url: "http://localhost:8080/admOffer/searchCity?searchCity=" + search,
        success: function (data) {
            let content = ""
            for (let i = 0; i < data.length; i++) {
                let career = data[i].career
                let description = data[i].description
                let city = data[i].city
                let amount = data[i].amount
                let endDate = data[i].endDate
                let name = data[i].name
                let status = data[i].status
                let id = data[i].id
                // (id , name, description,career, endDate , city, amount,workExperience,skill, status,company)
                content += form(id, name ,description, career , endDate , city , amount , status )
                document.getElementById("findAll").innerHTML = content;
            }
        }
    })
}
function form(id , name, description,career, endDate , city, amount, status , company) {
    return ` <div class="job pagi">
              <div class="job-content">
                <div class="job-logo">
                  <span>
                    <img src="../img/hihihihihihihihihihihii.jpg" class="job-logo-ima" alt="job-logo">
                  </span>
                </div>
                <div class="job-desc">
                 <div class="job-title">
                    <span>Công Ty:${getName(company)}</span>
                  </div>
                  <div class="job-title">
                    <span>${name}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Mô Tả:${description}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Nghề Nghiệp:${getName(career)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Hạn Nộp Hồ Sơ:${endDate}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Thành Phố:${getName(city)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Số Lượng:${amount}</span>
                  </div>
                  <div class="job-company">
                    Trạng thái: ${statusRender(getID(status))}
                  </div>
                </div>
                <div class="wrap-btn-appl">
                  <select onchange="changeStatus(${id})" id="statusOffer${id}">
                    <option value="1" ${getID(status)==1?"selected":""}>Mở Offer</option>
                    <option value="2" ${getID(status)==2?"selected":""}>Khoá Offer</option>
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
            Authorization : tokens
        },
        type: "GET",
        url: "http://localhost:8080/admOffer",
        success: function (data) {
            let content = ""
            for (let i = 0; i < data.length; i++) {
                let career = data[i].career
                let description = data[i].description
                let city = data[i].city
                let amount = data[i].amount
                let endDate = data[i].endDate
                let name = data[i].name
                let status = data[i].status
                let id = data[i].id
                let company = data[i].company
                // (id , name, description,career, endDate , city, amount,workExperience,skill, status,company)
                content += form(id, name ,description, career , endDate , city , amount , status , company )
                document.getElementById("findAll").innerHTML = content;
            }
        }
    })

}
//
// function displayRole(id) {
//     switch (id) {
//         case 1:
//             return "admin"
//         case 2:
//             return "customer"
//         case 3:
//             return "company"
//     }
// }
function changeStatus(id){
    let status = +document.getElementById("statusOffer"+id).value
    let url ="http://localhost:8080/offerDisable/" + id + "/" + status
    $.ajax({
        headers: {
        },
        type: "PUT",
        url: url,
        success: function () {
            renderForm()
            alert(status.name + "Thành Công!")
        }
    })
}
