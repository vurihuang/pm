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