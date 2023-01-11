if(checkAdmin()){
    window.location="/web/web.main/templates/themes.TechJobs/client/admin-show-offer.html"
}//nameOffer
if(checkCompany()){
    window.location = "/web/web.main/templates/themes.TechJobs/client/create-offer.html"
}


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
                <div ${showIsCustomer()} class="wrap-btn-appl">
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
            'Authorization': getToken()
        },
        type: "GET",
        url: "http://localhost:8080/customers/" + id,
        success: function (data) {
        },
        error: function (jqHXR, textStatus, errorThrown) {
            console.log(jqHXR.status = ": offer đã tồn tại")
            if(jqHXR.status > 399 && jqHXR.status < 500){
                window.location = "/web/web.main/templates/themes.TechJobs/client/login.html"
            }

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
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            Authorization: getToken()
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
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            Authorization: getToken()
        },
        type: "GET",
        url: "http://localhost:8080/admOffer/sort",
        success: function (data) {
            let content = ""
            for (let i = data.length - 1; i >= 0; i--) {
                let company = data[i].company
                content += formTopCompany(getName(company))

            }
            document.getElementById("topCompany").innerHTML = content;
        }
    })

}

function findOfferName() {
    let searchOffer = document.getElementById("searchNameOffer").value;
    let searchCompany = document.getElementById("searhCompanyOffer").value;
    let content = ""

    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            Authorization: getToken()
        },
        type: "GET",
        url: "http://localhost:8080/admOffer/search?search=" + searchOffer,
        success: function (data) {
            for (let i = 0; i < data.length; i++) {
                content += form(getID(data[i]), getName(data[i]), getName(data[i].city), data[i].endDate, data[i].amount, getName(data[i].career), data[i].skill)
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
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            Authorization: getToken()
        },
        type: "GET",
        url: "http://localhost:8080/admOffer/searchCompany?searchCompany=" + searchCompany,
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
