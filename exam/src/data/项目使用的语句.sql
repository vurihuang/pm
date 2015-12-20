-- 根据学生ID查这个学生在本年级本科目的平均分
select t_testmain.pk_test_main_id,avg(t_testmain.realScore)as avescore 
from t_scope,t_course,t_coursetype ,t_member_t_member ,t_course_t_member,t_testmain 
where t_course_t_member.courses_courseId=t_course.courseId
and t_member_t_member.students_memberId=t_course_t_member.members_memberId
and t_coursetype.courseTypeId=t_course.courseTypeID
and t_coursetype.grade_pk_scope_id=t_scope.pk_scope_id
and t_testmain.student_memberId=t_member_t_member.students_memberId
 and t_member_t_member.students_memberId="1048"
and t_scope.name="初一（下）"
and t_testmain.`subject`="语文"
group by t_testmain.pk_test_main_id

-- 根据指定试卷题目ID得到学生这个范围的平均成绩
select t_member_t_member.students_memberId,avg(t_testmain.realScore) as realscore
from t_scope,t_course,t_coursetype ,t_member_t_member ,t_course_t_member,t_testmain t_testmain
where t_course_t_member.courses_courseId=t_course.courseId
and t_member_t_member.students_memberId=t_course_t_member.members_memberId
and t_coursetype.courseTypeId=t_course.courseTypeID
and t_coursetype.grade_pk_scope_id=t_scope.pk_scope_id
and  t_member_t_member.students_memberId=t_testmain.student_memberId
and t_member_t_member.students_memberId in (select DISTINCT t_testmain.student_memberId from t_testmain,t_test_detail
 where  t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id
and t_test_detail.question_fk_question_id="02"
and t_test_detail.stuAnswer !="" )
and t_scope.name="初二（上）"
and t_testmain.`subject`="语文"
and t_testmain.realScore!="0"
GROUP BY t_member_t_member.students_memberId

-- 指定学生ID求这个学生这个范围的平均成绩
select  avg(t_testmain.realScore)as avescore 
from t_scope,t_course,t_coursetype ,t_member_t_member ,t_course_t_member,t_testmain 
where t_course_t_member.courses_courseId=t_course.courseId
and t_member_t_member.students_memberId=t_course_t_member.members_memberId
and t_coursetype.courseTypeId=t_course.courseTypeID
and t_coursetype.grade_pk_scope_id=t_scope.pk_scope_id
and t_testmain.student_memberId=t_member_t_member.students_memberId
 and t_member_t_member.students_memberId="1048"
and t_scope.name="初一（下）"
and t_testmain.`subject`="语文"
and t_testmain.realScore!="0"

-- 指定题目ID得到所有做过这道题的学生情况
select  t_testmain.student_memberId,t_test_detail.answer,t_test_detail.stuAnswer,
case when t_test_detail.stuanswer != t_test_detail.answer  then t_test_detail.score="0" else t_test_detail.score end AS realscore 
from t_test_detail,t_testmain 
where  t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id
and t_test_detail.question_fk_question_id="21394"
and t_test_detail.stuAnswer !=""
ORDER BY student_memberId 
-- 查询所有过滤过的试卷ID
select t_testmain.pk_test_main_id
from t_question,t_testmain,t_test_detail
where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id
and t_test_detail.question_fk_question_id=t_question.fk_question_id
and t_testmain.realScore!="0"
and t_testmain.useTime>="5"
GROUP BY t_testmain.pk_test_main_id
-- 根据试卷ID查这份试卷的题目列表
select t_test_detail.question_fk_question_id from t_testmain,t_test_detail
where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id
and t_testmain.pk_test_main_id="02"
ORDER BY t_test_detail.sequence ASC

-- 查询所有有用试卷的难度率和分数
select t_testmain.pk_test_main_id,sum((t_question.num-t_question.successNum)/t_question.num), t_testmain.realScore 
from t_question,t_testmain,t_test_detail
where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id
and t_test_detail.question_fk_question_id=t_question.fk_question_id
and t_testmain.realScore!="0"
and t_testmain.useTime>="5"
GROUP BY t_testmain.pk_test_main_id


-- 每一道题的错误率
select (t_question.num-t_question.successNum)/t_question.num as wrong from t_question,t_testmain,t_test_detail
 where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id
and t_test_detail.question_fk_question_id=t_question.fk_question_id
and t_testmain.pk_test_main_id="02"

-- 某份试卷的某个题型（难中易）错误率总和，注释：1是简单3是中5是难
select sum((t_question.num-t_question.successNum)/t_question.num) from t_question,t_testmain,t_test_detail
 where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id
and t_test_detail.question_fk_question_id=t_question.fk_question_id
and t_testmain.pk_test_main_id="02"
and t_question.difficultyLevel="1"
-- 通过学生ID查找他所在年级(现阶段所在年级）
select max(DISTINCT t_scope.name) from t_scope,t_course,t_coursetype ,t_member_t_member ,t_course_t_member where 
t_course_t_member.courses_courseId=t_course.courseId
and t_member_t_member.students_memberId=t_course_t_member.members_memberId
and t_coursetype.courseTypeId=t_course.courseTypeID
and t_coursetype.grade_pk_scope_id=t_scope.pk_scope_id
and t_member_t_member.students_memberId="1128"

-- 通过学生ID查找他所在年级
select DISTINCT t_scope.name from t_scope,t_course,t_coursetype ,t_member_t_member ,t_course_t_member where 
t_course_t_member.courses_courseId=t_course.courseId
and t_member_t_member.students_memberId=t_course_t_member.members_memberId
and t_coursetype.courseTypeId=t_course.courseTypeID
and t_coursetype.grade_pk_scope_id=t_scope.pk_scope_id
and t_member_t_member.students_memberId="1092"

-- 根据试卷ID得到该试卷难度
select sum((t_question.num-t_question.successNum)/t_question.num) as wrong from t_question,t_testmain,t_test_detail
where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id 
and t_test_detail.question_fk_question_id=t_question.fk_question_id 
and t_testmain.pk_test_main_id='02'

-- 根据题目ID得到该题平均得分
select ((sum(t_test_detail.score))/count(*)) as score 
from t_test_detail,t_testmain
where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id
and t_test_detail.question_fk_question_id="1" and stuAnswer <>""

-- 查询某个老师所教的所有学生ID
select DISTINCT students_memberId from t_member_t_member where 
t_member_memberId="2586"
ORDER BY students_memberId ASC

-- 查询某老师所教的所有年级
select DISTINCT t_scope.name from t_scope,t_course,t_coursetype where 
 t_coursetype.courseTypeId=t_course.courseTypeID
and t_coursetype.grade_pk_scope_id=t_scope.pk_scope_id
and  t_course.coachID="2586"

-- 查询某个老师教的这些学生限定某个年级里的某个科目的学生ID

select DISTINCT t_member_t_member.students_memberId
from t_member_t_member,t_testmain,t_scope,t_coursetype,t_course,t_course_t_member
where t_testmain.student_memberId=t_member_t_member.students_memberId
and t_course.courseId=t_course_t_member.courses_courseId
and t_course_t_member.members_memberId=t_member_t_member.students_memberId
and t_coursetype.courseTypeId=t_course.courseTypeID
and t_coursetype.grade_pk_scope_id=t_scope.pk_scope_id
and t_member_t_member.t_member_memberId="2586"
and t_testmain.`subject`="数学"
 and t_scope.`name`="三年级（下）"
ORDER BY t_member_t_member.students_memberId ASC

-- 某个学生做过的某个年级的语文试卷范围
select distinct  scope from  t_testmain where 
subject like '语文' 
and student_memberId in
   (select memberid from t_member 
   where name like '陈子凡')
and  grandient_grandientId in(select DISTINCT t_grandient.grandientId as `grandientId`
from t_grandient,t_grandient_t_scope,t_scope as `chapter`,t_scope as `unit`,t_scope as `grade`
where  t_grandient.grandientId=t_grandient_t_scope.t_grandient_grandientId
and t_grandient_t_scope.scopes_pk_scope_id=chapter.pk_scope_id
and chapter.fk_parent_id=unit.pk_scope_id
and unit.fk_parent_id=grade.pk_scope_id
and grade.name like "初二（上）%"
)


 -- 选择范围，查出各个知识点错误率
select DISTINCT keyword,sum(case when t_test_detail.answer!=t_test_detail.stuanswer
then 1 else 0 end)/Count(*) as wrong
from t_test_detail,t_question,t_testmain
where t_test_detail.question_fk_question_id=t_question.fk_question_id 
and t_testmain.pk_test_main_id=t_test_detail.testmain_pk_test_main_id
and t_testmain.scope like "  6.阿长与《山海经》  7.背影  8.台阶"
and keyword !=""
group by keyword

-- 试卷做的最多的前面80学生的名字，数目，学号
select count(*)as num ,student_memberId ,name from t_testmain ,t_member
where t_testmain.student_memberId=t_member.memberId
GROUP BY student_memberId
ORDER BY num DESC limit 0,80