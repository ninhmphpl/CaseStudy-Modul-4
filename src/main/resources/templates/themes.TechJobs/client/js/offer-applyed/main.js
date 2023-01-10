
renderForm()
// content += form(name,birth,education,expWork,phoneNumber,status)
function form(name,birth,education,expWork,phoneNumber,city,status){
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
                    <span href="">Ngày sinh:${birth}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Kinh nghiệm làm việc:${getName(expWork)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Điện Thoại:${phoneNumber}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Thành Phố:${getName(city)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Trạng thái:${status?"Đã duyệt":"Không duyệt"}</span>
                  </div>
                </div>
                <div class="wrap-btn-appl">
                </div>
              </div>
            </div>`
}
// customer": {
// "id": 1,
//     "name": "ab",
//     "birth": null,
//     "education": {
//     "id": 1,
//         "name": "Cấp 2"
// },
// "expWork": {
//     "id": 1,
//         "name": "1 Năm kinh nghiệm"
// },
// "phoneNumber": null,
//     "gender": {
//     "id": 1,
//         "name": "Nam"
// },
// "user": null,
//     "city": {
//     "id": 1,
//         "name": "An Giang"
// }
// "status": false
function renderForm() {
    let id = sessionStorage.getItem("offer_id")
    id = 5
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json',
            Authorization : getToken()
        },
        type: "GET",
        url: "http://localhost:8080/api/companies/offer/" + id,
        success: function (data) {
            let content = ""
            for (let i = 0; i < data.length; i++) {
                let a = data[i].customer
                let name = a.name
                let birth = a.birth
                let education = a.education
                let expWork = a.expWork
                let phoneNumber = a.phoneNumber
                let city = a.city
                let status = data[i].status

                content += form(name,birth,education,expWork,phoneNumber,city, status)
                document.getElementById("findAll").innerHTML = content;
            }
        }
    })

}
