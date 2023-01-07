//
function form(id , name, description,career, endDate , city, amount,workExperience,skill, status,company) {
    return ` <div class="job pagi">
              <div class="job-content">
                <div class="job-logo">
                  <span>
                    <img src="img/fpt-logo.png" class="job-logo-ima" alt="job-logo">
                  </span>
                </div>
                <div class="job-desc">
                  <div class="job-title">
                    <span>${name}</span>
                  </div>
                  <div class="job-company">
                    <span href="">${description}</span>
                  </div>
                  <div class="job-company">
                    <span href="">${career}</span>
                  </div>
                  <div class="job-company">
                    <span href="">${endDate}</span>
                  </div>
                  <div class="job-company">
                    <span href="">${city}</span>
                  </div>
                  <div class="job-company">
                    <span href="">${amount}</span>
                  </div><div class="job-company">
                    <span href="">${workExperience}</span>
                  </div><div class="job-company">
                    <span href="">${skill}</span>
                  </div><div class="job-company">
                    <span href="">${status}</span>
                  </div><div class="job-company">
                    <span href="">${company}</span>
                  </div>
                  <div class="job-company">
                    Trạng thái: ${statusRender(status.id)}
                  </div>
                </div>
                <div class="wrap-btn-appl">
                  <select onchange="changeStatus(${id})" id="statusOffer${id}">
                    <option value="1" ${status.id==1?"selected":""}>Mở Offer</option>
                    <option value="2" ${status.id==2?"selected":""}>Khoá Offer</option>
                    <option value="3" ${status.id==3?"selected":""}>Xét Duyệt</option>
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
        type: "GET",
        url: "http://localhost:8080/admOffer",
        success: function (data) {
            let content = ""
            for (let i = 0; i < data.length; i++) {
                let career = data[i].career
                let description = data[i].description
                let city = data[i].city
                let amount = data[i].amount
                let workExperience = data[i].workExperience
                let skill = data[i].skill
                let endDate = data[i].endDate
                let name = data[i].name
                let status = data[i].status
                let company = data[i].company
                let id = data[i].id
                // (id , name, description,career, endDate , city, amount,workExperience,skill, status,company)
                content += form(id, name ,description, career , endDate , city , amount,workExperience, skill , status ,company )
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
renderForm()
