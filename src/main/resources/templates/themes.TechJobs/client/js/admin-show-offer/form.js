let tokens = getToken()
renderForm()
checkOtherAdminBack()

function searchByName(){
    let search = document.getElementById("searchByName").value
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json',
            Authorization : getToken()
        },
        type: "GET",
        url: "http://localhost:8080/admOffer/search?search=" + search,
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
                content += form(id, name ,description, career , endDate , city , amount , status )
                document.getElementById("findAll").innerHTML = content;
            }
        }
    })
}
function searchByCityName(){
    let search = document.getElementById("searchByCityName").value
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json',
            Authorization : getToken()
        },
        type: "GET",
        url: "http://localhost:8080/admOffer/searchCity?searchCity=" + search,
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
                content += form(id, name ,description, career , endDate , city , amount , status )
                document.getElementById("findAll").innerHTML = content;
            }
        }
    })
}
function form(id , name, description,career, endDate , city, amount, status , company) {
    return ` <div class="job pagi">
              <div class="job-content">
                <div class="job-logo">
                  <span>
                    <img src="../img/hihihihihihihihihihihii.jpg" class="job-logo-ima" alt="job-logo">
                  </span>
                </div>
                <div class="job-desc">
                 <div class="job-title">
                    <span>C??ng Ty:${getName(company)}</span>
                  </div>
                  <div class="job-title">
                    <span>${name}</span>
                  </div>
                  <div class="job-company">
                    <span href="">M?? T???:${description}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Ngh??? Nghi???p:${getName(career)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">H???n N???p H??? S??:${endDate}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Th??nh Ph???:${getName(city)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">S??? L?????ng:${amount}</span>
                  </div>
                  <div class="job-company">
                    Tr???ng th??i: ${statusRender(getID(status))}
                  </div>
                </div>
                <div class="wrap-btn-appl">
                  <select onchange="changeStatus(${id})" id="statusOffer${id}">
                    <option value="1" ${getID(status)==1?"selected":""}>M??? Offer</option>
                    <option value="2" ${getID(status)==2?"selected":""}>Kho?? Offer</option>
                    <option value="3" ${getID(status)==3?"selected":""}>X??t Duy???t</option>
                  </select>
                </div>
              </div>
            </div>`
}
function statusRender(statusId){
    switch (statusId){
        case 1:
            return "??ang m???"
        case 2:
            return "??ang kho??"
        case 3:
            return "Ch??? Duy???t"
    }
}
function renderForm() {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json',
            Authorization : tokens
        },
        type: "GET",
        url: "http://localhost:8080/admOffer",
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
                let company = data[i].company
                // (id , name, description,career, endDate , city, amount,workExperience,skill, status,company)
                content += form(id, name ,description, career , endDate , city , amount , status , company )
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
            alert(status.name + "Th??nh C??ng!")
        }
    })
}
