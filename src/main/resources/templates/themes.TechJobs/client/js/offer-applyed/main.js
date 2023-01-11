renderForm()
setInnerHTMLById("nameCompany", getEmailAccount())

// content += form(name,birth,education,expWork,phoneNumber,status)
function form(id,name, birth, education, expWork, phoneNumber, city, status, customer_id) {
    return ` <div class="job pagi">
              <div class="job-content">
                <div class="job-logo">
                  <span>
                    <img src="../img/fpt-logo.png" class="job-logo-ima" alt="job-logo">
                  </span>
                </div>
                <div class="job-desc">
                  <div class="job-title">
                    <a href="#">${name}</a>
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
                    <span href="">Trạng thái:${statusDisplay(getID(status))}</span>
                  </div>
                </div>
                <div class="wrap-btn-appl">
                 <div class="wrap-btn-appl">
                  <select onchange="statusChange(${id})" id="status${id}">
                  <option value="1" ${selected(getID(status),1)}>Đồng ý</option>
                  <option value="2" ${selected(getID(status),2)}>Từ chối</option>
                  <option value="3" ${selected(getID(status),3)}>Chờ duyệt</option>
</select>
                </div>
                </div>
              </div>
            </div>`
}
function statusDisplay(value){
    switch (value) {
        case 1:
            return "Đồng ý"
        case 2:
            return "Từ chối"
        case 3:
            return "Chờ duyệt"
        default:
            return ''
    }
}
function statusChange(id){
    let statusValue = document.getElementById("status"+id).value

    $.ajax({
        headers: {
            Authorization: getToken()
        },
        type: "GET",
        url: "http://localhost:8080/api/companies/" + id + "/" + statusValue,
        success: function (data) {
            renderForm()
        },
        error: function (){
            alert("Cập nhật thất bại")
        }
    })
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
    let id = sessionStorage.getItem("id_offer_apply")
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            Authorization: getToken()
        },
        type: "GET",
        url: "http://localhost:8080/api/companies/offer/" + id,
        success: function (data) {
            let content = ""
            for (let i = 0; i < data.length; i++) {
                let a = data[i].customer
                let customer_id
                let id = data[i].id
                let name = a.name
                let birth = a.birth
                let education = a.education
                let expWork = a.expWork
                let phoneNumber = a.phoneNumber
                let city = a.city
                let status = data[i].status

                content += form(id, name, birth, education, expWork, phoneNumber, city, status, customer_id)
                document.getElementById("findAll").innerHTML = content;
            }
        }
    })

}
