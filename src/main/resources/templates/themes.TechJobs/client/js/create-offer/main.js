if(!checkCompany()){
    backOffer()
}

function render() {
    let token = getToken()
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            Authorization: token
        },
        type: "GET",
        url: "http://localhost:8080/crud-offer/offer-name",
        success: function (data) {
            form(data.cities, data.careers, data.skills)
        }

    })
}

function form(cities, careers, skills) {
    let city = ""
    let career = ""
    let skill = ""
    for (let i = 0; i < cities.length; i++) {
        city += `<option value='${cities[i].id}'>${cities[i].name}</option>`
    }
    for (let i = 0; i < careers.length; i++) {
        career += `<option value='${careers[i].id}'>${careers[i].name}</option>`
    }
    for (let i = 0; i < skills.length; i++) {
        skill += `<div class="filter-topic">
                                            <label class="label-container">
                                                <span>${skills[i].name}</span>
                                                <input type="checkbox" name="" value="${skills[i].id}" class="skill">
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>`
    }
    setInnerHTMLById("city", city)
    setInnerHTMLById("career", career)
    setInnerHTMLById("skill", skill)
}

render()

function save(){
    let arr = document.getElementsByClassName("skill")
    let name = getValueById("name")
    let career = getValueById("career")
    let description = getValueById("description")
    let city = getValueById("city")
    let amount = getValueById("amount")
    let workExperience = getValueById("workExperience")
    let skill = []
    for (let i = 0 ; i<arr.length; i ++){
        if(arr[i].checked){
            skill.push({id:arr[i].value})
        }
    }


    let a = {
        name: name,
        career: {
            id: career
        },
        description: description,
        city: {
            id: city
        },
        amount: amount,
        workExperience: workExperience,
        skill: skill
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            Authorization: getToken()
        },
        type: "POST",
        url: "http://localhost:8080/crud-offer",
        data: JSON.stringify(a),
        success: function (data) {
            alert("Tạo thành công")
            render()
        }

    })
}



// Long id;
// String name; name
// Career career;career
// String description;description
// LocalDate endDate;endDate
// City city;city
// int amount;amount
// int workExperience;workExperience
// List<Skill> skill;
// Status status;
// Company company;
// List<Customer>  customers;
