package aspects;


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
}