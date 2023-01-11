
renderForm()
//id, name ,description, career , endDate , city , amount , status
function form(id , name, description,career, endDate , city, amounts){
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
                    <span href="">Mô Tả:${description}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Ngành nghề:${getName(career)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Hạn Nộp Hồ Sơ:${endDate}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Thành Phố:${getName(city)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Số Lượng:${amounts}</span>
                  </div>
                  <div class="job-company">
                  </div>
                </div>
                 <div class="wrap-btn-appl">
                  <a onclick="updateOffer(${id})" class="btn btn-appl">Sửa thông tin</a>
                  <a onclick="applyOffer(${id})" class="btn btn-appl">Duyệt đơn</a>
                </div>
                </div>
              </div>
            </div>`
}
function updateOffer(id){
    sessionStorage.setItem("id_offer_update", id)
    window.location = "/web/web.main/templates/themes.TechJobs/client/company/update-offer.html"
}
function applyOffer(id){
    sessionStorage.setItem("id_offer_apply", id)
    window.location = "/web/web.main/templates/themes.TechJobs/client/company/offer-applyed.html"
}
// "id": 5,
//     "name": "CNTT",
//     "career": {
//     "id": 1,
//         "name": "Công nghệ thông tin"
// },
// "description": "Điện Tử",
//     "endDate": "2023-01-05",
// "city": {
//     "id": 1,
//         "name": "An Giang"
// },
// "amount": 25,
//     "workExperience": 5,
//     "skill": [],
//     "status": {
//     "id": 1,
//         "name": "Mở"
// },
function renderForm() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json',
            Authorization : getToken()
        },
        type: "GET",
        url: "http://localhost:8080/api/companies/company-apply",
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
                content += form(id, name ,description, career , endDate , city , amount , status  )
                document.getElementById("listOffer").innerHTML = content;
            }
        }
    })

}
