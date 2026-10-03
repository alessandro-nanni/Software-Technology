package larva;



import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_GradeAdministration0 implements _callable{

public static PrintWriter pw; 
public static _cls_GradeAdministration0 root;

public static LinkedHashMap<_cls_GradeAdministration0,_cls_GradeAdministration0> _cls_GradeAdministration0_instances = new LinkedHashMap<_cls_GradeAdministration0,_cls_GradeAdministration0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("./bin//output_GradeAdministration.txt");

root = new _cls_GradeAdministration0();
_cls_GradeAdministration0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_GradeAdministration0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_GradeAdministration0() {
}

public void initialisation() {
}

public static _cls_GradeAdministration0 _get_cls_GradeAdministration0_inst() { synchronized(_cls_GradeAdministration0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_GradeAdministration0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_GradeAdministration0_instances){
_performLogic_property1(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_GradeAdministration0[] a = new _cls_GradeAdministration0[1];
synchronized(_cls_GradeAdministration0_instances){
a = _cls_GradeAdministration0_instances.keySet().toArray(a);}
for (_cls_GradeAdministration0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_GradeAdministration0_instances){
_cls_GradeAdministration0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_property1 = 0;

public void _performLogic_property1(String _info, int... _event) {

_cls_GradeAdministration0.pw.println("[property1]AUTOMATON::> property1("+") STATE::>"+ _string_property1(_state_id_property1, 0));
_cls_GradeAdministration0.pw.flush();

if (0==1){}
}

public void _goto_property1(String _info){
_cls_GradeAdministration0.pw.println("[property1]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_property1(_state_id_property1, 1));
_cls_GradeAdministration0.pw.flush();
}

public String _string_property1(int _state_id, int _mode){
switch(_state_id){
case 0: if (_mode == 0) return "start"; else return "start";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}