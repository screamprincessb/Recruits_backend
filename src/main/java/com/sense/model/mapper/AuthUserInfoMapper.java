package com.sense.model.mapper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AuthUserInfoMapper {

//   
//    @Mappings({
//        @Mapping(source = "course", target = "."),
//        @Mapping(source = "course.publishTo", target = "publishTo.type.id"),
//        @Mapping(source = "lecturers", target = "lecturers"),
//        @Mapping(source = "lessons", target = "lessons")})
//    CourseResponse toCourseResponse(KmCourse course, List<KmUser> lecturers, List<KmLesson> lessons,
//            List<KmUnit> units, List<KmCourseTag> courseTags, List<KmCourseEvaluate> evaluates,
//            List<String> attachmentIds);
//
//    @Mappings({
//        @Mapping(source = "course.publishTo", target = "publishTo.type.id")})
//    CourseResponse toCourseResponse(KmCourse course, List<String> attachmentIds, List<String> tags,
//            List<Evaluate> evaluates);
//
//    Certificate toCertificate(KmMasterCertificate certificate);
//
//    @Mappings({
//        @Mapping(source = "course.publishTo", target = "publishTo.type.id")})
//    CourseCategoryResponse toCourseCategoryResponse(KmCourse course, List<String> attachmentIds, List<String> tags,
//            List<Evaluate> evaluates);
//
//    @Mappings({
//        @Mapping(source = "course.publishTo", target = "publishTo.type.id")})
//    CourseResponse toCourseResponse(KmCourse course);
//
//    @Mappings({
//        @Mapping(source = "request.publishTo.typeId", target = "publishTo")})
//    KmCourse toKmCourse(CourseRequest request);
//
//    @Mappings({
//        @Mapping(source = "request.publishTo.typeId", target = "publishTo")})
//    KmCourse toKmCourseUpdate(CourseUpdateRequest request);
//
//    KmQuiz toKmQuiz(Quiz quiz);
//
//    KmQuizChoice toKmQuizChoice(Choice choice);
//
//    List<Choice> toChoices(List<KmQuizChoice> choice);
//
//    CourseViewResp toCourseViewResponse(KmCourse course);
//
//    // Lesson
//    KmLesson toKmLesson(Lesson lesson, Integer courseId);
//
//    KmLessonConfig toKmLessonConfig(Config config);
//
//    LessonResponse toLessonResponse(KmLesson lesson);
//
//    // Lesson config
//    ConfigResponse toLessonConfig(KmLessonConfig kmLessonConfigs);
//
//    List<ConfigResponse> toUnitConfigResponses(List<KmUnitConfig> kmUnitConfigs);
//
//    // Lesson Test
//    TestResponse toLessonTest(KmLessonTest kmLessonTest);
//
//    // Unit
//    KmUnit toKmUnit(Unit unit, Integer lessonId);
//
//    KmUnitConfig toKmUnitConfig(Config unitConfig);
//
//    UnitResponse toUnitResponse(KmUnit kmUnit);
//
//    // Unit Config
//    ConfigResponse toUnitConfig(KmUnitConfig kmUnitConfigs);
//
//    // Unit Test
//    TestResponse toUnitTest(KmUnitTest kmUnitTest);
//
//    // quiz
//    Quiz toQuizResponse(KmQuiz kmQuiz);
//
//    // choice
//    List<Choice> toTestChoice(List<KmQuizChoice> choice);
//
//    KmLessonTest toKmLessonTest(Test test, Integer lessonId, Integer quizId);
//
//    KmUnitTest toKmUnitTest(Test test, Integer unitId, Integer quizId);
//
//    KmGroupOfEvaluate toKmGroupOfEvaluate(Evaluate evaluate);
//
//    KmCourseEvaluate toKmCourseEvaluate(Integer groupId, Integer courseId, String quiz);
//
//    CommonNameResponse toCommonName(TypeOfTestView setTypeOfTest);
//
//    // COURSE TAGS
//    default List<KmCourseTag> toKmCourseTag(List<String> tags, Integer courseId) {
//        List<KmCourseTag> kmCourseTags = new ArrayList<>();
//        if (tags != null && !tags.isEmpty()) {
//            for (String tag : tags) {
//                kmCourseTags.add(new KmCourseTag().setCourseId(courseId).setTag(tag));
//            }
//        }
//        return kmCourseTags;
//
//    }
//
//    // COURSE LECTURERS
//    @Mappings({
//        @Mapping(source = "typeId", target = "typeId")})
//    CourseLecturerResponse toCourseLecturerResponse(KmMasterLecturer kmMasterLecturer,
//            KmCourseLecturer kmCourseLecturer, Integer courseLecturerId, Integer typeId);
//
//    default List<KmCourseLecturer> toKmCourseLecturers(List<CourseLecturer> courseLecturers, Integer courseId) {
//        List<KmCourseLecturer> kmCourseLecturers = new ArrayList<>();
//        if (courseLecturers != null && !courseLecturers.isEmpty()) {
//            for (CourseLecturer courseLecturer : courseLecturers) {
//                kmCourseLecturers.add(new KmCourseLecturer().setCourseId(courseId)
//                        .setLecturerId(courseLecturer.getLecturerId()).setTypeId(courseLecturer.getTypeId()));
//            }
//        }
//        return kmCourseLecturers;
//    }
//
//    @Mappings({
//        @Mapping(source = "courseLecturers.courseLecturerId", target = "id")})
//    KmCourseLecturer toKmCourseLecturers(CourseLecturer courseLecturers, Integer courseId);
//
//    // COURSE FILE
//    default List<KmCourseFile> toKmCourseFiles(List<String> attachmentIds, Integer courseId) {
//        List<KmCourseFile> kmCourseFiles = new ArrayList<>();
//        if (attachmentIds != null && !attachmentIds.isEmpty()) {
//            for (String fileId : attachmentIds) {
//                kmCourseFiles.add(new KmCourseFile().setCourseId(courseId).setFileId(fileId));
//            }
//        }
//        return kmCourseFiles;
//    }
//
//    default List<KmLessonFile> toKmLessonFiles(List<String> attachmentIds, Integer lessonId) {
//        List<KmLessonFile> kmLessonFiles = new ArrayList<>();
//        if (attachmentIds != null && !attachmentIds.isEmpty()) {
//            for (String fileId : attachmentIds) {
//                kmLessonFiles.add(new KmLessonFile().setLessonId(lessonId).setFileId(fileId));
//            }
//        }
//        return kmLessonFiles;
//    }
//
//    default List<KmUnitFile> toKmUnitFiles(List<String> attachmentIds, Integer unitId) {
//        List<KmUnitFile> kmUnitFiles = new ArrayList<>();
//        if (attachmentIds != null && !attachmentIds.isEmpty()) {
//            for (String fileId : attachmentIds) {
//                kmUnitFiles.add(new KmUnitFile().setUnitId(unitId).setFileId(fileId));
//            }
//        }
//        return kmUnitFiles;
//    }
//
//    default List<KmCourseAccess> toKmCourseAccesses(CoursePublish publishTo, Integer courseId) {
//        List<KmCourseAccess> kmCourseAccesses = new ArrayList<>();
//        if (publishTo != null && publishTo.getAgencies() != null && !publishTo.getAgencies().isEmpty()) {
//            for (AgencyRequest agency : publishTo.getAgencies()) {
//                kmCourseAccesses.add(new KmCourseAccess().setCourseId(courseId).setAgencyId(agency.getId()));
//            }
//        }
//        return kmCourseAccesses;
//    }
//
//    default CourseSearchAllResponse toKmCourseSearchAllResponse(KmCourse courseSearchRes, CoursePublishResponse publishTo, Boolean flagIsNewest) {
//        CourseSearchAllResponse courseSearchAllResponse = new CourseSearchAllResponse();
//
//        courseSearchAllResponse
//                .setAgencyId(courseSearchRes.getAgencyId())
//                .setBody(courseSearchRes.getBody())
//                .setCategoryId(courseSearchRes.getCategoryId())
//                .setCode(courseSearchRes.getCode())
//                .setCreatedDt(courseSearchRes.getCreatedDt())
//                .setDescription(courseSearchRes.getDescription())
//                .setEnrollCount(courseSearchRes.getEnrollCount())
//                .setExpectBenefit(courseSearchRes.getExpectBenefit())
//                .setExpiredDt(courseSearchRes.getExpiredDt())
//                .setId(courseSearchRes.getId())
//                .setInitials(courseSearchRes.getInitials())
//                .setIsPublish(courseSearchRes.getIsPublish())
//                .setLessonCount(courseSearchRes.getLessonCount())
//                .setViewCount(courseSearchRes.getViewCount())
//                .setRatePoint(0)
//                .setMeasurement(courseSearchRes.getMeasurement())
//                .setObjective(courseSearchRes.getObjective())
//                .setPublishDt(courseSearchRes.getPublishDt())
//                .setPublishTo(publishTo)
//                .setQualification(courseSearchRes.getQualification())
//                .setRequiredId(courseSearchRes.getRequiredId())
//                .setStudyHour(courseSearchRes.getStudyHour())
//                .setStudyTime(courseSearchRes.getStudyTime())
//                .setThumbnailId(courseSearchRes.getThumbnailId())
//                .setTitleEn(courseSearchRes.getTitleEn())
//                .setTitleTh(courseSearchRes.getTitleTh())
//                .setUpdatedDt(courseSearchRes.getUpdatedDt())
//                .setRemark(courseSearchRes.getRemark())
//                .setEvaluateExt(courseSearchRes.getEvaluateExt())
//                .setEvaluateUrl(courseSearchRes.getEvaluateUrl());
//        if(flagIsNewest)
//        {
//            long days = ChronoUnit.DAYS.between(courseSearchRes.getCreatedDt().toLocalDate(), LocalDateTime.now());
//            courseSearchAllResponse.setIsNewest(days <= 7);
//        }
//        return courseSearchAllResponse;
//    }
//
//    default CourseSearchAllResponse toKmCourseSearchAllResponse(KmCourse courseSearchRes, CoursePublishResponse publishTo, Boolean flagIsNewest, Integer ratePoint) {
//        CourseSearchAllResponse courseSearchAllResponse = new CourseSearchAllResponse();
//
//        courseSearchAllResponse
//                .setAgencyId(courseSearchRes.getAgencyId())
//                .setBody(courseSearchRes.getBody())
//                .setCategoryId(courseSearchRes.getCategoryId())
//                .setCode(courseSearchRes.getCode())
//                .setCreatedDt(courseSearchRes.getCreatedDt())
//                .setDescription(courseSearchRes.getDescription())
//                .setEnrollCount(courseSearchRes.getEnrollCount())
//                .setExpectBenefit(courseSearchRes.getExpectBenefit())
//                .setExpiredDt(courseSearchRes.getExpiredDt())
//                .setId(courseSearchRes.getId())
//                .setInitials(courseSearchRes.getInitials())
//                .setIsPublish(courseSearchRes.getIsPublish())
//                .setLessonCount(courseSearchRes.getLessonCount())
//                .setViewCount(courseSearchRes.getViewCount())
//                .setRatePoint(ratePoint)
//                .setMeasurement(courseSearchRes.getMeasurement())
//                .setObjective(courseSearchRes.getObjective())
//                .setPublishDt(courseSearchRes.getPublishDt())
//                .setPublishTo(publishTo)
//                .setQualification(courseSearchRes.getQualification())
//                .setRequiredId(courseSearchRes.getRequiredId())
//                .setStudyHour(courseSearchRes.getStudyHour())
//                .setStudyTime(courseSearchRes.getStudyTime())
//                .setThumbnailId(courseSearchRes.getThumbnailId())
//                .setTitleEn(courseSearchRes.getTitleEn())
//                .setTitleTh(courseSearchRes.getTitleTh())
//                .setUpdatedDt(courseSearchRes.getUpdatedDt())
//                .setRemark(courseSearchRes.getRemark())
//                .setEvaluateExt(courseSearchRes.getEvaluateExt())
//                .setEvaluateUrl(courseSearchRes.getEvaluateUrl());
//
//        if(flagIsNewest)
//        {
//            long days = ChronoUnit.DAYS.between(courseSearchRes.getCreatedDt().toLocalDate(), LocalDateTime.now());
//            courseSearchAllResponse.setIsNewest(days <= 7);
//        }
//        return courseSearchAllResponse;
//    }

}
