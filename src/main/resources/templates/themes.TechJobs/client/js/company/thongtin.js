function showForm(){
    $.ajax({
        headers:{
            Authorization: getToken()
        },
        type: "GET",
        url: "http://localhost:8080/api/companies",
        success: function (data) {
            render(data)
        }

    })
}

function render(data){
    let name = data.name
    let career = data.career
    let email = (data.user)?data.user.email:""
    let address = data.address
    let phoneNumber = data.phoneNumber
    let description= data.description

    document.getElementById("name").value=name
    document.getElementById("career").value=career
    document.getElementById("description").value=description
    document.getElementById("address").value=address
    document.getElementById("phoneNumber").value=phoneNumber
    document.getElementById("email").value = email
}
showForm()


function save(){
    let name = document.getElementById("name").value
    let email = document.getElementById("email").value
    let career = document.getElementById("career").value
    let phoneNumber = document.getElementById("phoneNumber").value
    let address = document.getElementById("address").value
    let description = document.getElementById("description").value

    let data = {
        name : name,
        email: email,
        career : career,
        phoneNumber: phoneNumber,
        address: address,
        description: description,

    }
    let token = getToken()
    $.ajax({

        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            Authorization: token

        },
        type: "PUT",
        url: "http://localhost:8080/api/companies",
        data: JSON.stringify( data),
        success: function (data) {
            alert("Cập nhật thành công")
        }

    })
}
