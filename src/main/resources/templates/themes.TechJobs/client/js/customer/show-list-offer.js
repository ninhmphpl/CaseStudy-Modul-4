renderForm()

function form(id, name, career, description, endDate, city, amount, workExperience, status) {
    return ` <div class="job pagi">
              <div class="job-content">
                <div class="job-logo">
                  <span>
                    <img src="../img/fpt-logo.png" class="job-logo-ima" alt="job-logo">
                  </span>
                </div>
                <div class="job-desc">
                  <div class="job-title">
                    <span>${name}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Mô Tả:${description}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Ngành nghề:${getName(career)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Hạn Nộp Hồ Sơ:${endDate}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Thành Phố:${getName(city)}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Số Lượng:${amount}</span>
                  </div>
                  <div class="job-company">
                    <span href="">Kinh nghiệm:${workExperience}Năm</span>
                  </div>
                  <div class="job-company">
                    <span href="">Trạng thái:${getName(status)}</span>
                  </div>
                  <div class="job-company">
                  </div>
                </div>
                 <div class="wrap-btn-appl">
                  <a onclick="deleteOffer(${id})" class="btn btn-appl">Delete</a>
                </div>
                </div>
              </div>
            </div>`
}

// private Long id;
// private String name;
// private Career career;
// private String description;
// private LocalDate endDate;
// private City city;
// private int amount;
// private int workExperience;
// private Set<Skill> skill;
// private Status status;
// private Company company;

function renderForm() {
    $.ajax({
        headers: {
            Authorization: getToken()
        },
        type: "GET",
        url: "http://localhost:8080/customer/list-offer",
        success: function (data) {
            for(let i = 0 ; i< data.length; i++){
                let offer = data[i].offer
                let name = offer.name
                let career = offer.career
                let description = offer.description
                let endDate = offer.endDate
                let city = offer.city
                let amount = offer.amount
                let workExperience = offer.workExperience
                let status = data[i].status
                form(id, name, career, description, endDate, city, amount, workExperience, status)

            }

        }
    })
}

function deleteOffer(id) {
    $.ajax({
        headers: {
            Authorization: getToken()
        },
        type: "GET",
        url: "http://localhost:8080/customers/" + id,
        success: function (data) {
            alert("Xóa thành công")
            renderForm()
        },
        error: function (data) {
            alert("Đã xảy ra lỗi, xóa thất bại")
        }
    })
}
