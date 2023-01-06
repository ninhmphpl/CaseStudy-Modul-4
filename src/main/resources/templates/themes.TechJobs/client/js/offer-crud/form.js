function form(name, amount,city){
    return `              <div id = "job_display" class="job-content">
                <div class="job-logo">
                  <a href="#">
                    <img src="img/fpt-logo.png" class="job-logo-ima" alt="job-logo">
                  </a>
                </div>

                <div class="job-desc">
                  <div class="job-title">
                    <a href="#">${name}</a>
                  </div>
                  <div class="job-company">
                    <a href="#">Số lượng tuyển: ${amount}</a> | <a href="#" class="job-address"><i class="fa fa-map-marker" aria-hidden="true"></i>${city}</a>
                  </div>

                  <div class="job-inf">
                    <div class="job-main-skill">
                      <i class="fa fa-code" aria-hidden="true"></i>  <a href="#"> Java</a>
                    </div>
                    <div class="job-salary">
                      <i class="fa fa-money" aria-hidden="true"></i>
                      <span class="salary-min">15<em class="salary-unit">triệu</em></span>
                      <span class="salary-max">35 <em class="salary-unit">triệu</em></span>
                    </div>
                    <div class="job-deadline">
                      <span><i class="fa fa-clock-o" aria-hidden="true"></i>  Hạn nộp: <strong>31/12/2019</strong></span>
                    </div>
                  </div>
                </div>
                <div class="wrap-btn-appl">
                  <a href="#" class="btn btn-appl">Apply Now</a>
<!--                </div>-->`
}