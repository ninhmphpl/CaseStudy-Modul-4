
renderForm()
function form(id , name, description,career, endDate , city, amounts, status){
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
                    <span href="">Số Lượng:${amounts}</span>
                  </div>
                  <div class="job-company">
                    Trạng thái:
                  </div>
                </div>
                <div class="wrap-btn-appl">
                </div>
              </div>
            </div>`
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
                let career = data[i].career.name
                let description = data[i].description
                let city = data[i].city
                let amount = data[i].amount
                let endDate = data[i].endDate
                let name = data[i].name
                let status = data[i].status
                let id = data[i].id
                // (id , name, description,career, endDate , city, amount,workExperience,skill, status,company)
                content += form(id, name ,description, career , endDate , city , amount , status  )
                document.getElementById("findAll").innerHTML = content;
            }
        }
    })

}
