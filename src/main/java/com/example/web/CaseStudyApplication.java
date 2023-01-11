package com.example.web;

import com.example.web.model.Gender;
import com.example.web.model.Role;
import com.example.web.model.Skill;
import com.example.web.model.User;
import com.example.web.model.admin.Status;
import com.example.web.model.customer.City;
import com.example.web.model.customer.Education;
import com.example.web.model.customer.ExpWork;
import com.example.web.model.offer.Career;
import com.example.web.repository.RoleRepository;
import com.example.web.repository.StatusRepository;
import com.example.web.repository.UserRepository;
import com.example.web.repository.customer.CityRepository;
import com.example.web.repository.customer.EducationRepository;
import com.example.web.repository.customer.ExpWorkRepository;
import com.example.web.repository.customer.GenderRepository;
import com.example.web.repository.offer.CareerRepository;
import com.example.web.repository.offer.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CaseStudyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {
        run();
    }
    public void run(){
        try {
            insertStatus();
            insertGender();
            insertEducation();
            insertCity();
            insertExpWork();
            insertRole();
            insertCareer();
            insertSkill();
            create();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void create(){
        if(!userRepository.existsByEmail("loda")){
            User user = new User();
            user.setEmail("loda");
            user.setPassword(passwordEncoder.encode("loda"));
            user.setRole(new Role(1L, null));
            userRepository.save(user);
        }
    }

    public void insertCity() {
        String[] role = new String[]{
                "An Giang",
                "Bà Rịa – Vũng Tàu",
                "Bắc Giang",
                "Bắc Kạn",
                "Bạc Liêu",
                "Bắc Ninh",
                "Bến Tre",
                "Bình Định",
                "Bình Dương",
                "Bình Phước",
                "Bình Thuận",
                "Cà Mau",
                "Cần Thơ",
                "Cao Bằng",
                "Đà Nẵng",
                "Đắk Lắk",
                "Đắk Nông",
                "Điện Biên",
                "Đồng Nai",
                "Đồng Tháp",
                "Gia Lai",
                "Hà Giang",
                "Hà Nam",
                "Hà Nội",
                "Hà Tĩnh",
                "Hải Dương",
                "Hải Phòng",
                "Hậu Giang",
                "Hòa Bình",
                "Hưng Yên",
                "Khánh Hòa",
                "Kiên Giang",
                "Kon Tum",
                "Lai Châu",
                "Lâm Đồng",
                "Lạng Sơn",
                "Lào Cai",
                "Long An",
                "Nam Định",
                "Nghệ An",
                "Ninh Bình",
                "Ninh Thuận",
                "Phú Thọ",
                "Phú Yên",
                "Quảng Bình",
                "Quảng Nam",
                "Quảng Ngãi",
                "Quảng Ninh",
                "Quảng Trị",
                "Sóc Trăng",
                "Sơn La",
                "Tây Ninh",
                "Thái Bình",
                "Thái Nguyên",
                "Thanh Hóa",
                "Thừa Thiên Huế",
                "Tiền Giang",
                "TP Hồ Chí Minh",
                "Trà Vinh",
                "Tuyên Quang",
                "Vĩnh Long",
                "Vĩnh Phúc",
                "Yên Bái"
        };
        if (cityRepository.findAll().size() == 0) {
            for (Integer i = 0; i < role.length; i++) {
                cityRepository.save(new City(i.longValue() +1 , role[i]));
            }
        }
    }

    @Autowired
    private RoleRepository roleRepository;
    public void insertRole() {
        String[] role = new String[]{"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_COMPANY"};
        if (roleRepository.findAll().size() == 0) {
            for (Integer i = 0; i < role.length; i++) {
                roleRepository.save(new Role(i.longValue() +1 , role[i]));
            }
        }
    }
    @Autowired
    private StatusRepository statusRepository;
    public void insertStatus() {
        String[] role = new String[]{"Mở", "Khóa", "Chờ duyệt"};
        if (statusRepository.findAll().size() == 0) {
            for (Integer i = 0; i < role.length; i++) {
                statusRepository.save(new Status(i.longValue() +1 , role[i]));
            }
        }
    }

    @Autowired
    private GenderRepository genderRepository;

    public void insertGender() {
        String[] role = new String[]{"Nam", "Nu",};
        if (genderRepository.findAll().size() == 0) {
            for (Integer i = 0; i < role.length; i++) {
                genderRepository.save(new Gender(i.longValue() +1 , role[i]));
            }
        }
    }

    @Autowired
    private ExpWorkRepository expWordRepository;
    public void insertExpWork() {
        String[] role = new String[]{
                "1 Năm kinh nghiệm",
                "2 Năm Kinh Nghiệm",
                "3 Năm Kinh Nghiệm",
                "4 Năm Kinh nghiệm",
                "Trên 5 Năm"};
        if (expWordRepository.findAll().size() == 0) {
            for (Integer i = 0; i < role.length; i++) {
                expWordRepository.save(new ExpWork(i.longValue() +1 , role[i]));
            }
        }
    }
    @Autowired
    private EducationRepository educationRepository;
    public void insertEducation() {
        String[] role = new String[]{
                "Cấp 2",
                "Cấp 3",
                "Cao đẳng",
                "Đại học",
                "Chứng chỉ"};
        if (educationRepository.findAll().size() == 0) {
            for (Integer i = 0; i < role.length; i++) {
                educationRepository.save(new Education(i.longValue() +1 , role[i]));
            }
        }
    }
    @Autowired
    private CareerRepository careerRepository;
    public void insertCareer() {
        String[] role = new String[]{
                "Công nghệ thông tin",
                "Marketing",
                "Bất động sản",
                "Quản trị kinh doanh",
                "Lao động phổ thông",
                "Kĩ sư",
                "Văn phòng",
                "Kinh doanh online",
                "Quảng cáo",
                "Kiểm thử phần mềm"};
        if (careerRepository.findAll().size() == 0) {
            for (Integer i = 0; i < role.length; i++) {
                careerRepository.save(new Career(i.longValue() +1 , role[i]));
            }
        }
    }
    @Autowired
    private SkillRepository skillRepository;
    public void insertSkill() {
        String[] role = new String[]{
                "Lắng nghe",
                "Giao tiếp",
                "Quản lý thời gian",
                "Giải quyết vấn đề",
                "Làm việc nhóm",
                "Linh hoạt, thích nghi nhanh",
                "Chịu được áp lực tốt"
        };
        if (skillRepository.findAll().size() == 0) {
            for (Integer i = 0; i < role.length; i++) {
                skillRepository.save(new Skill(i.longValue() +1 , role[i]));
            }
        }
    }


}
