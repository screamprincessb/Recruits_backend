/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.ApplicationEntity;
import com.sense.backend.hb.entity.auth.qCandidateEntityToUse;
import com.sense.backend.hb.entity.auth.ChildEntity;
import com.sense.backend.hb.entity.auth.ContactPersonEntity;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
import com.sense.backend.hb.entity.auth.EducationEntity;
import com.sense.backend.hb.entity.auth.QueryPDF;
import com.sense.backend.hb.entity.auth.SiblingEntity;
import com.sense.backend.hb.entity.auth.TrainingEntity;
import com.sense.backend.hb.entity.auth.qApplicationEntity;
import com.sense.backend.hb.entity.auth.qPositionNameEntityToJoin;
import com.sense.backend.hb.entity.auth.qWorkExperienceEntityToJoin;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SenseInfoTech
 */
@Repository
public class ApplicationDAO extends BaseDAO<ApplicationEntity, String> {

    @Autowired
    private SessionFactory sessionFactory;

    public ApplicationDAO() {
        super(ApplicationEntity.class);
    }

    public List<qApplicationEntity> findAllName() {
        List<qApplicationEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select application.application_id ,position_link_form.position_id ,application.application_submit_date ,application.can_first_name_th ,application.can_last_name_th , position_link_form.position_name ,application.application_status ");
        sql.append("from application ");
        sql.append("inner join position_link_form on position_link_form.position_id = application.position_id ");

        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qApplicationEntity.class);
        result = query.getResultList();
        return result;
    }

    public List<AbillitiesEntity> findAbillitiesByid(String id) {
        List<AbillitiesEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from abillities ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), AbillitiesEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<qWorkExperienceEntityToJoin> findWorkExperienceByid(String id) {
        List<qWorkExperienceEntityToJoin> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select work_experience.*, reference_person.ref_first_name, reference_person.ref_last_name, reference_person.ref_job_position ,reference_person.ref_work_location ,reference_person.ref_phone ");
        sql.append("from work_experience ");
        sql.append("inner join reference_person on work_experience.work_experience_id = reference_person.work_experience_id ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qWorkExperienceEntityToJoin.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<ChildEntity> findChildById(String id) {
        List<ChildEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM child  ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), ChildEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<ContactPersonEntity> findContactPersonById(String id) {
        List<ContactPersonEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from contact_person ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), ContactPersonEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<DataOtherEntity> findDataOtherById(String id) {
        List<DataOtherEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from data_other ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), DataOtherEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<EducationEntity> findEducationById(String id) {
        List<EducationEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from education ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), EducationEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<qPositionNameEntityToJoin> findPositionNameById(String id) {
        List<qPositionNameEntityToJoin> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select application.application_id , position_link_form.position_name ");
        sql.append("from application ");
        sql.append("inner join position_link_form on position_link_form.position_id = application.position_id ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qPositionNameEntityToJoin.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<SiblingEntity> findSiblingById(String id) {
        List<SiblingEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sibling ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), SiblingEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<TrainingEntity> findTrainingById(String id) {
        List<TrainingEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from training ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), TrainingEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<qCandidateEntityToUse> finCandidateByStatus(String status) {
        List<qCandidateEntityToUse> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select application.application_id ,application.can_first_name_th , application.can_last_name_th ,application.application_status,position_link_form.position_id, position_link_form.position_name  ");
        sql.append("from application ");
        sql.append("inner join position_link_form on position_link_form.position_id = application.position_id ");
        sql.append("where application_status = :status");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qCandidateEntityToUse.class);
        query.setParameter("status", status);
        result = query.getResultList();
        return result;
    }

    public List<qCandidateEntityToUse> finCandidateById(String id) {
        List<qCandidateEntityToUse> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select application.application_id ,application.can_first_name_th , application.can_last_name_th ,application.application_status,position_link_form.position_id, position_link_form.position_name  ");
        sql.append("from application ");
        sql.append("inner join position_link_form on position_link_form.position_id = application.position_id ");
        sql.append("where application_id = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qCandidateEntityToUse.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public QueryPDF findPDF(String id) {
        QueryPDF result = new QueryPDF();
        StringBuilder sql = new StringBuilder();
//        sql.append("select * ");
//        sql.append("from application ");
//        sql.append("inner join child on application.application_id = child.application_id ");
//        sql.append("inner join contact_person on application.application_id = contact_person.application_id ");
//        sql.append("inner join education on application.application_id = education.application_id ");
//        sql.append("inner join sibling on application.application_id = sibling.application_id ");
//        sql.append("inner join training on application.application_id = training.application_id ");
//        sql.append("inner join work_experience on application.application_id = work_experience.application_id ");
//        sql.append("inner join position_link_form on application.position_id = position_link_form.position_id ");
//        sql.append("where application.application_id = :id ");
//        sql.append("\'");
//        sql.append(id);
//        sql.append("\'");
        sql.append("SELECT application.application_id, application.can_first_name_th, application.can_title_name_th, application.can_last_name_th, application.can_nickname_th,application.can_title_name_eng, ");
        sql.append("application.can_first_name_eng ,application.can_last_name_eng , application.can_nickname_eng , application.application_salary_range ,application.application_start_date , ");
        sql.append("application.can_sight , application.can_weight ,application.can_height , application.can_date_of_birth ,application.can_age ,application.can_national ,application.can_ethincity , ");
        sql.append("application.can_card_id ,application.can_place_of_issue ,application.can_date_of_issue ,application.can_marriage_status , ");
        sql.append("application.fam_father_first_name ,application.fam_father_last_name ,application.fam_father_age ,application.fam_father_occupation ,application.fam_father_work_location , ");
        sql.append("application.fam_mother_first_name ,application.fam_mother_last_name ,application.fam_mother_age ,application.fam_mother_occupation,application.fam_mother_work_location , ");
        sql.append("application.fam_sibling_amount ,application.fam_spouse_first_name ,application.fam_spouse_last_name ,application.fam_spouse_age ,application.fam_spouse_occupation ,application.fam_spouse_work_location , ");
        sql.append("application.fam_child_amount , application.sibling_you_are, ");
        sql.append("application.contact_house_number ,application.contact_village ,application.contact_alley ,application.contact_road ,application.contact_subdistrict ,application.contact_district , ");
        sql.append("application.contact_province ,application.contact_postcode ,application.contact_home_phone ,application.contact_mobile_phone ,application.contact_email , ");
        sql.append("application.current_edu_level ,application.current_edu_name ,application.current_edu_major ,application.current_edu_semester ,application.current_edu_expected , ");

        sql.append("position_link_form.position_id ,position_link_form.position_name, ");
        sql.append("child.child_id ,child.child_number ,child.child_first_name ,child.child_last_name ,child.child_age ,child.child_gender ,child.child_education_level , ");
        sql.append("contact_person.contact_person_id ,contact_person.cp_first_name ,contact_person.cp_last_name ,contact_person.cp_relation ,contact_person.cp_phone ,contact_person.cp_address , ");
        sql.append("education.education_id ,education.education_level ,education.education_name ,education.education_qualification ,education.education_major ,education.education_start_date ,education.education_end_date ,education.education_gpa , ");
        sql.append("training.training_id ,training.training_date ,training.training_course ,training.training_institution ,training.training_qualification ,training.training_time , ");
        sql.append("work_experience.work_experience_id ,work_experience.we_start_date ,work_experience.we_end_date ,work_experience.we_business_type ,work_experience.we_name ,work_experience.we_position ,work_experience.we_other_benefit , ");
        sql.append("work_experience.we_salary ,work_experience.we_address_phone ,work_experience.we_description ,work_experience.we_reason_leaving  ");
        sql.append("FROM application ");
        sql.append("INNER JOIN position_link_form ON application.position_id  = position_link_form.position_id ");
        sql.append("INNER JOIN child ON application.application_id  = child.application_id ");

        sql.append("INNER JOIN contact_person ON application.application_id  = contact_person.application_id ");
        sql.append("INNER JOIN education ON application.application_id  = education.application_id ");
        sql.append("INNER JOIN training ON application.application_id  = training.application_id ");
        sql.append("INNER JOIN work_experience ON application.application_id  = work_experience.application_id ");
        sql.append("where application.application_id = :id ");
        

        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), QueryPDF.class);
        query.setParameter("id", id);
        result = (QueryPDF)query.getSingleResult();
        return result;
    }
}
