package aspects;

import gradeAdministration.*;

import larva.*;
public aspect _asp_GradeAdministration0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_GradeAdministration0.initialize();
}
}

before () : (execution(* *.main(..)) && args(*) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 2/*programStarted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 2/*programStarted*/);
}
}

before ( Course c,Student s,int g) : (call(* Course.addGrade(..)) && target(c) && args(s,g) && !cflow(adviceexecution())) {

synchronized(_asp_GradeAdministration0.lock){
Student student;
int grade;
Course course;
course =c ;
student =s ;
grade =g ;

_cls_GradeAdministration0 _cls_inst = _cls_GradeAdministration0._get_cls_GradeAdministration0_inst();
_cls_inst.c = c;
_cls_inst.s = s;
_cls_inst.g = g;
_cls_GradeAdministration0.student = student;
_cls_GradeAdministration0.grade = grade;
_cls_GradeAdministration0.course = course;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 0/*gradeRegistered*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 0/*gradeRegistered*/);
}
}
}