//nameOffer

function form(id,name, city, endDate, amount, career, skill) {
    return `         <div class="job pagi">
              <div class="job-content">
                <div class="job-logo">
                  <a href="#">
                    <img src="img/fpt-logo.png" class="job-logo-ima" alt="job-logo">
                  </a>
                </div>

                <div class="job-desc">
                  <div class="job-title">
                 <a href="jd-page.html" onclick="createLocal(${id})"> ${name}</a> 
                  </div>
                  <div class="job-company">
                    <a href="jd-page">${career}</a> | <a href="#" class="job-address"><i class="fa fa-map-marker" aria-hidden="true"></i>
${city}</a>
                  </div>

                  <div class="job-inf">
                    <div class="job-main-skill">
                      <i class="fa fa-code" aria-hidden="true"></i>  <a href="#"> Số lượng tuyển: ${amount}</a>
                    </div>
                    <div class="job-salary">
                      <i class="fa fa-money" aria-hidden="true"></i>
                      <span class="salary-min">Kĩ năng: <em class="salary-unit">${skillForm(skill)}</em></span>
                      <span class="salary-max">35 <em class="salary-unit">triệu</em></span>
                    </div>
                    <div class="job-deadline">
                      <span><i class="fa fa-clock-o" aria-hidden="true"></i> Ngày hết hạn :<strong> ${endDate}</strong></span>
                    </div>
                  </div>
                </div>
                <div class="wrap-btn-appl">
                  <a href="#" class="btn btn-appl">Apply Now</a>
                </div>
              </div>
            </div>`
}
function createLocal(id){
    sessionStorage.setItem("idOffer", id)
}



function skillForm(skill) {
    if (skill.length === 0) {
        console.log("skill is null")
        return "Không cần kĩ năng"
    }
    let content = "";
    for (let i = 0; i < skill.length; i++) {
        content += skill[i].name + ((i===skill.length-1)?"":", ")
    }
    return content;
}

//     "id": 12,
//     "name": "Nghèo",
//     "career": {
//     "id": 3,
//         "name": "dfdasfa"
// },
//     "description": "Giao Thoong",
//     "endDate": "2023-01-04",
//     "city": {
//     "id": 2,
//         "name": "52"
// },
//     "amount": 4,
//     "workExperience": 1,
//     "skill": [],
//     "status": null
// }
function render() {
    let content = ""
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admOffer",
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                content += form(data[i].id?data[i].id:"ID: Trống",
                    data[i].name?data[i].name:"Tên: Trống",
                    data[i].city?data[i].city.name:"Địa chỉ: Trống",
                    data[i].endDate?data[i].endDate: "Hạn: Trống",
                    data[i].amount?data[i].amount:"Số lượng tuyển: Trống",
                    data[i].career?data[i].career.name:"Ngành nghề: Trống",
                    data[i].skill)
            }
            document.getElementById("listOffer").innerHTML = content;
        }
    })

}

render()
