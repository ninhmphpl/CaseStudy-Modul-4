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
                "B?? R???a ??? V??ng T??u",
                "B???c Giang",
                "B???c K???n",
                "B???c Li??u",
                "B???c Ninh",
                "B???n Tre",
                "B??nh ?????nh",
                "B??nh D????ng",
                "B??nh Ph?????c",
                "B??nh Thu???n",
                "C?? Mau",
                "C???n Th??",
                "Cao B???ng",
                "???? N???ng",
                "?????k L???k",
                "?????k N??ng",
                "??i???n Bi??n",
                "?????ng Nai",
                "?????ng Th??p",
                "Gia Lai",
                "H?? Giang",
                "H?? Nam",
                "H?? N???i",
                "H?? T??nh",
                "H???i D????ng",
                "H???i Ph??ng",
                "H???u Giang",
                "H??a B??nh",
                "H??ng Y??n",
                "Kh??nh H??a",
                "Ki??n Giang",
                "Kon Tum",
                "Lai Ch??u",
                "L??m ?????ng",
                "L???ng S??n",
                "L??o Cai",
                "Long An",
                "Nam ?????nh",
                "Ngh??? An",
                "Ninh B??nh",
                "Ninh Thu???n",
                "Ph?? Th???",
                "Ph?? Y??n",
                "Qu???ng B??nh",
                "Qu???ng Nam",
                "Qu???ng Ng??i",
                "Qu???ng Ninh",
                "Qu???ng Tr???",
                "S??c Tr??ng",
                "S??n La",
                "T??y Ninh",
                "Th??i B??nh",
                "Th??i Nguy??n",
                "Thanh H??a",
                "Th???a Thi??n Hu???",
                "Ti???n Giang",
                "TP H??? Ch?? Minh",
                "Tr?? Vinh",
                "Tuy??n Quang",
                "V??nh Long",
                "V??nh Ph??c",
                "Y??n B??i"
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
        String[] role = new String[]{"M???", "Kh??a", "Ch??? duy???t"};
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
                "1 N??m kinh nghi???m",
                "2 N??m Kinh Nghi???m",
                "3 N??m Kinh Nghi???m",
                "4 N??m Kinh nghi???m",
                "Tr??n 5 N??m"};
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
                "C???p 2",
                "C???p 3",
                "Cao ?????ng",
                "?????i h???c",
                "Ch???ng ch???"};
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
                "C??ng ngh??? th??ng tin",
                "Marketing",
                "B???t ?????ng s???n",
                "Qu???n tr??? kinh doanh",
                "Lao ?????ng ph??? th??ng",
                "K?? s??",
                "V??n ph??ng",
                "Kinh doanh online",
                "Qu???ng c??o",
                "Ki???m th??? ph???n m???m"};
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
                "L???ng nghe",
                "Giao ti???p",
                "Qu???n l?? th???i gian",
                "Gi???i quy???t v???n ?????",
                "L??m vi???c nh??m",
                "Linh ho???t, th??ch nghi nhanh",
                "Ch???u ???????c ??p l???c t???t"
        };
        if (skillRepository.findAll().size() == 0) {
            for (Integer i = 0; i < role.length; i++) {
                skillRepository.save(new Skill(i.longValue() +1 , role[i]));
            }
        }
    }


}
