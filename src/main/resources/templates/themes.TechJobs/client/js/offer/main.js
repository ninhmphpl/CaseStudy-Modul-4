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
                  <a class="btn btn-appl" onclick="apply(${id})">Apply Now</a>
                </div>
              </div>
            </div>`
}
function createLocal(id){
    sessionStorage.setItem("idOffer", id)
}

function apply(id) {
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            'Authorization': token
        },
        type: "POST",
        url: "http://localhost:8081/amdOffer",
        data: JSON.stringify(data),
        success: function (data) {

        },
        error: function (data) {
            window.location = "http://localhost:63342/CaseStudy_Modul4/web.main/templates/themes.TechJobs/client/login.html"
        }
    })
    event.preventDefault();
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

function render() {
    if(getToken()){
        setInnerHTMLById("navbarDropdown", getEmailAccount())
        hide("signI")
        hide("loginI")
        show("accountI")
    }else{
        show('signI')
        show('loginI')
        hide("accountI")
    }
    let content = ""
    token = "Bearer " + token;
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsb2RhIiwiaWF0IjoxNjczMTUwMDQwLCJleHAiOjg4MDczMTUwMDQwfQ.wYP9Vsu2Z8dcvQ-TSjJCUbvbtNtoE8TNYhi61y5IYK4'
        },
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
        },
        error: function (data) {
            // window.location = "http://localhost:63342/CaseStudy_Modul4/web.main/templates/themes.TechJobs/client/login.html"
        }

    })

}

function formTopCompany(name) {
    return `                    <div class="col-md-3 col-sm-6 col-12 top-employer-wrap">
                        <div class="top-employer-item">
                            <a href="#">
                                <div class="emp-img-thumb">
                                    <img src="img/fpt-logo.png">
                                </div>
                                <h3 class="company">${name}</h3>
                            </a>
                        </div>
                    </div>
                    `
}

function renderTopCompany() {
    let content = ""
    token = "Bearer " + token;
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsb2RhIiwiaWF0IjoxNjczMTUwMDQwLCJleHAiOjg4MDczMTUwMDQwfQ.wYP9Vsu2Z8dcvQ-TSjJCUbvbtNtoE8TNYhi61y5IYK4'
        },
        type: "GET",
        url: "http://localhost:8081/admOffer/sort",
        success: function (data) {
            for (let i = data.length - 1; i >= 0; i--) {
                content += formTopCompany(data[i].company.name)

            }
            document.getElementById("topCompany").innerHTML = content;
        }
    })

}

function findOfferName() {
    let searchOffer = document.getElementById("searchNameOffer").value;
    let searchCompany = document.getElementById("searhCompanyOffer").value;
    let content = ""
    token = "Bearer " + token;
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsb2RhIiwiaWF0IjoxNjczMTUwMDQwLCJleHAiOjg4MDczMTUwMDQwfQ.wYP9Vsu2Z8dcvQ-TSjJCUbvbtNtoE8TNYhi61y5IYK4'
        },
        type: "GET",
        url: "http://localhost:8081/admOffer/search?search=" + searchOffer,
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                content += form(data[i].id, data[i].name, data[i].city.name, data[i].endDate, data[i].amount, data[i].career.name, data[i].skill)
            }
            document.getElementById("listOffer").innerHTML = content;
        },
        error: function (data) {
            // window.location = "http://localhost:63342/CaseStudy_Modul4/web.main/templates/themes.TechJobs/client/login.html"
        }

    })

}
function findCompanyName() {
    let searchCompany = document.getElementById("searhCompanyOffer").value;
    let content = ""
    token = "Bearer " + token;
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsb2RhIiwiaWF0IjoxNjczMTUwMDQwLCJleHAiOjg4MDczMTUwMDQwfQ.wYP9Vsu2Z8dcvQ-TSjJCUbvbtNtoE8TNYhi61y5IYK4'
        },
        type: "GET",
        url: "http://localhost:8081/admOffer/searchCompany?searchCompany=" + searchCompany,
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                content += form(data[i].id, data[i].name, data[i].city.name, data[i].endDate, data[i].amount, data[i].career.name, data[i].skill)
            }
            document.getElementById("listOffer").innerHTML = content;
        },
        error: function (data) {
            // window.location = "http://localhost:63342/CaseStudy_Modul4/web.main/templates/themes.TechJobs/client/login.html"
        }

    })

}

renderTopCompany()
render()
