//nameCustomer ho va ten
//phoneNumber so dien thoai
//jobGender gioi tinh
//empDayOb ngay sinh
//jobLevel trinh do cao nhat
//jobExperience nam kinh nghiem
//empWishPlace dia chi

//  id
//  name
//  birth
//  education
//  expWork
//  phoneNumber
//  gender
//  city
function save(){
    let name = document.getElementById("nameCustomer").value
    let birth = document.getElementById("empDayOb").value
    let phoneNumber = document.getElementById("phoneNumber").value
    let city = +document.getElementById("empWishPlace").value
    let gender = +document.getElementById("jobGender").value
    let education = +document.getElementById("jobLevel").value
    let expWork = +document.getElementById("jobExperience").value
    let data = {
        name : name,
        birth : birth,
        education: {id:education},
        expWork: {id:expWork},
        phoneNumber: phoneNumber,
        gender: {id:gender},
        city: {id:city}
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            Authorization: getToken()
        },
        type: "PUT",
        url: "http://localhost:8080/customers",
        data: JSON.stringify(data),
        success: function (data) {
            alert("Cập nhật thành công")
        }

    })
}

