// form(id, career , city , amount , workExperience , endDate, status)
function form(id , career, description,city,amount, workExperience , endDate, status) {
    return ` <div class="job pagi">
              <div class="job-content">
                <div class="job-logo">
                  <span>
                    <img src="img/fpt-logo.png" class="job-logo-ima" alt="job-logo">
                  </span>
                </div>
                <div class="job-desc">
                  <div class="job-title">
                    <span>${career}</span>
                  </div>
                  <div class="job-company">
                    <span href="">${description}</span>
                  </div><div class="job-company">
                    <span href="">${city}</span>
                  </div><div class="job-company">
                    <span href="">${amount}</span>
                  </div><div class="job-company">
                    <span href="">${workExperience}</span>
                  </div><div class="job-company">
                    <span href="">${endDate}</span>
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
                let endDate = data[i].endDate
                let status = data[i].status
                let id = data[i].id
                content += form(id, career ,description, city , amount , workExperience , endDate, status)
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
