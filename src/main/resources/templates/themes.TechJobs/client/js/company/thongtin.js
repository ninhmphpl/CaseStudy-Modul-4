function showCompany(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/companies",
        success: function (data) {
            render(data)
        }
    })
}


// "id": 1,
//     "name": "hun",
//     "career": "oto",
//     "description": "dsfdsf",
//     "address": "hn",
//     "phoneNumber": "034466767",
//     "user": {
//     "id": 1,
//         "name": null,
//         "email": "dvd@gmail",
//         "role": null,
//         "status": null
function render(a){
    let data=a[1]
    let name=data.name
    let career=data.career
    let description=data.description
    let address=data.address
    let phoneNumber=data.phoneNumber
    let email=data.user.email

    document.getElementById("name").value=name
    document.getElementById("career").value=career
    document.getElementById("description").value=description
    document.getElementById("address").value=address
    document.getElementById("phoneNumber").value=phoneNumber
    document.getElementById("email").value = email

}
function save(){
    let name = document.getElementById("name").value
    let career = document.getElementById("career").value
    let phoneNumber = document.getElementById("phoneNumber").value
    let description = document.getElementById("description").value
    let address = document.getElementById("address").value
    let email = document.getElementById("email").value

    let data = {
        id:2,
        name : name,
        career : career,
        description: description,
        address: address,
        phoneNumber: phoneNumber,
        email: email,

    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/api/companies",
        data: JSON.stringify(data),
        success: function (data) {
            alert("Cập nhật thành công")
        }

    })
}

showCompany()