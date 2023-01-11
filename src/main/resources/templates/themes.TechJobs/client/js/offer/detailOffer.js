function getidlocal() {
    let idjd = sessionStorage.getItem("idOffer")
    return idjd;
}

getidlocal()
offerByID(getidlocal())

function offerByID(id) {
    let url = "http://localhost:8080/admOffer/" + id
    let content = ""
    $.ajax({
        type: "GET",
        url: url,
        success: function (data) {
            render(data)
        }

    })
}

function render(data) {
    document.getElementById("nameJd").innerHTML = data.name
    document.getElementById("nameCompany").innerHTML = data.company.name
    document.getElementById("city").innerHTML = data.city.name
    document.getElementById("local").innerHTML = data.city.name
    document.getElementById("endDate").innerHTML = data.endDate
    let content = '<ul>'
    for (let i = 0; i < data.skill.length; i++) {
        content += displaySkill(data.skill[i]);
    }
    content += '</ul>'
    document.getElementById("skill").innerHTML = content
    document.getElementById("content_jd").innerHTML = data.description
    document.getElementById("amountJob").innerHTML = data.amount
    document.getElementById("content_jd").innerHTML = data.description
    document.getElementById("endDate2").innerHTML = data.endDate
    document.getElementById("career").innerHTML = data.career.name
    document.getElementById("workExperience").innerHTML = data.workExperience
    document.getElementById("skill2").innerHTML = content
    document.getElementById("nameCompany2").innerHTML = data.company.name


}

function displaySkill(skill) {
    return `<li>
        <a>${skill.name}</a>
         </li>`
}
function checkjdoffer() {
    if (checkAdmin() || checkCustomer() || checkCompany()) {
        document.getElementById("jdregister").hidden = true
        document.getElementById("jdlogin").hidden = true
    }
}
checkjdoffer()
function apply() {
    $.ajax({
        headers: {
            Authorization: getToken()
        },
        type: "POST",
        url: "http://localhost:8080/customers/apply/"+getidlocal(),
        success: function (data) {
            alert("Nộp đơn thành công, vui lòng chờ xét duyệt của nhà tuyển dụng")
        },
        error: function (data) {
            alert("Đã xảy ra lỗi, nộp đơn thất bại")
        }
    })
    event.preventDefault();
}