function showForm(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/customers/data",
        success: function (data) {
            render(data)
        }

    })
}
function render(data){
    let city = data.city
    let gender = data.gender
    let education = data.education
    let expWork = data.expWorks
    let customer = data.customer

    let cityHtml = "";
    let genderHtml = "";
    let educationHtml = "";
    let expWorkHtml = "";
    for (let i = 0; i<city.length; i++){
        cityHtml += `<option city[i].id == customer.city.id?"selected":"" value="${city[i].id}">${city[i].name}</option>`
    }
    for (let i = 0; i<gender.length; i++){
        genderHtml += `<option ${gender[i].id == customer.gender.id?"selected":""} value="${gender[i].id}">${gender[i].name}</option>`
    }
    for (let i = 0; i<education.length; i++){
        educationHtml += `<option ${education[i].id == customer.education.id?"selected":""} value="${education[i].id}">${education[i].name}</option>`
    }
    for (let i = 0; i<expWork.length; i++){
        expWorkHtml += `<option ${expWork[i].id == customer.expWork.id?"selected":""} value="${expWork[i].id}">${expWork[i].name}</option>`
    }
    document.getElementById("empWishPlace").innerHTML = (cityHtml)
    document.getElementById("jobGender").innerHTML = (genderHtml)
    document.getElementById("jobLevel").innerHTML = (educationHtml)
    document.getElementById("jobExperience").innerHTML = (expWorkHtml)

    document.getElementById("empDayOb").value = (customer.birth)
    document.getElementById("phoneNumber").value = (customer.phoneNumber)
    document.getElementById("nameCustomer").value = (customer.name)


}

showForm()