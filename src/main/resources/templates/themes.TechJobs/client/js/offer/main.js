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
                      <span class="salary-min">Skill<em class="salary-unit">${skillForm(skill)}</em></span>
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
    localStorage.setItem("idOffer", id)
}



function skillForm(skill) {
    let content = "";
    for (let i = 0; i < skill.length; i++) {
        content += skill[i].name + " "
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
        url: "http://localhost:8081/admOffer",
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                content += form(data[i].id,data[i].name, data[i].city.name, data[i].endDate, data[i].amount, data[i].career.name, data[i].skill)
            }
            document.getElementById("listOffer").innerHTML = content;
        }

    })

}

render()
