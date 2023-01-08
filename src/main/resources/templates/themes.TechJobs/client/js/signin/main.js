// phoneNumber
// password
// repassword
// email
// fullName
// typeAcount

function signIn() {
    let phoneNumber = document.getElementById("phoneNumber").value
    let email = document.getElementById("email").value
    let fullName = document.getElementById("fullName").value
    let password = document.getElementById("password").value
    let repassword = document.getElementById("repassword").value
    let typeAccount = +document.getElementById("typeAccount").value
    if (password === repassword) {
        document.getElementById("messagePassword").innerText = "Mật khẩu không trùng khớp"
    }
    let user = {
        email: email,
        password: password,
        role: typeAccount,
        phoneNumber: phoneNumber,
        name: fullName
    }
    // let formData = new FormData();
    // formData.append("user", new Blob([JSON.stringify(user)]
    //     , {type: 'application/json'}))
    // formData.append("data", new Blob([JSON.stringify(data)]
    //     , {type: 'application/json'}))
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json',
            // Authorization: "Bearer " + sessionStorage.getItem("token"),
        },
        // contentType: false,
        // processData: false,
        type: "POST",
        url: "http://localhost:8080/api/login",
        data: JSON.stringify(user),
        success: function (data) {

        }
    })


}