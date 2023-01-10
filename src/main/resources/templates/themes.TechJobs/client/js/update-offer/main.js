function render(id) {
    let token = getToken()
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            Authorization: token
        },
        type: "GET",
        url: "http://localhost:8080/crud-offer/"+id,
        success: function (data) {
            form(data.cities, data.careers, data.skills, data.offer)
        }
    })
}

function form(cities, careers, skills, offer) {
    let city = ""
    let career = ""
    let skill = ""

    let offer_skill = offer.skill
    for (let i = 0; i < cities.length; i++) {
        city += `<option ${selected(getID(offer.city), getID(cities[i]))} value='${cities[i].id}'>${cities[i].name}</option>`
    }
    for (let i = 0; i < careers.length; i++) {
        career += `<option ${selected(getID(offer.career), getID(careers[i]))} value='${careers[i].id}'>${careers[i].name}</option>`
    }
    for (let i = 0; i < skills.length; i++) {
        let value = skills[i].id
        skill += `<div class="filter-topic">
                                            <label class="label-container">
                                                <span>${skills[i].name}</span>
                                                <input ${setChecked(offer_skill, value)} type="checkbox" name="" value="${value}" class="skill">
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>`
    }
    setInnerHTMLById("city", city)
    setInnerHTMLById("career", career)
    setInnerHTMLById("skill", skill)

    setValueById("name",offer.name)
    setValueById("description", offer.description)
    setValueById("amount", offer.amount)
    setValueById("workExperience", offer.workExperience)

}
let offer_id = 6
render(offer_id)

function save() {
    let arr = document.getElementsByClassName("skill")

    let name = getValueById("name")
    let career = getValueById("career")
    let description = getValueById("description")
    let city = getValueById("city")
    let amount = getValueById("amount")
    let workExperience = getValueById("workExperience")

    let skill = []
    for (let i = 0; i < arr.length; i++) {
        if (arr[i].checked) {
            skill.push({id: arr[i].value})
        }
    }


    let a = {
        id: offer_id,
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
        type: "PUT",
        url: "http://localhost:8080/crud-offer",
        data: JSON.stringify(a),
        success: function (data) {
            console.log(data)
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
