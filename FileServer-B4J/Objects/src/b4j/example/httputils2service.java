package b4j.example;


import anywheresoftware.b4a.BA;

public class httputils2service extends Object{
public static httputils2service mostCurrent = new httputils2service();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.httputils2service", null);
		ba.loadHtSubs(httputils2service.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.httputils2service", ba);
		}
	}
    public static Class<?> getObject() {
		return httputils2service.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.http.HttpClientWrapper _hc = null;
public static anywheresoftware.b4a.objects.collections.Map _taskidtojob = null;
public static String _tempfolder = "";
public static int _taskcounter = 0;
public static b4j.example.main _main = null;
public static String  _completejob(int _taskid,boolean _success,String _errormessage) throws Exception{
b4j.example.httpjob _job = null;
 //BA.debugLineNum = 56;BA.debugLine="Sub CompleteJob(TaskId As Int, success As Boolean,";
 //BA.debugLineNum = 57;BA.debugLine="Dim job As HttpJob";
_job = new b4j.example.httpjob();
 //BA.debugLineNum = 58;BA.debugLine="job = TaskIdToJob.Get(TaskId)";
_job = (b4j.example.httpjob)(_taskidtojob.Get((Object)(_taskid)));
 //BA.debugLineNum = 59;BA.debugLine="TaskIdToJob.Remove(TaskId)";
_taskidtojob.Remove((Object)(_taskid));
 //BA.debugLineNum = 60;BA.debugLine="job.success = success";
_job._success /*boolean*/  = _success;
 //BA.debugLineNum = 61;BA.debugLine="job.errorMessage = errorMessage";
_job._errormessage /*String*/  = _errormessage;
 //BA.debugLineNum = 62;BA.debugLine="job.Complete(TaskId)";
_job._complete /*String*/ (_taskid);
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responseerror(anywheresoftware.b4a.http.HttpClientWrapper.HttpResponeWrapper _response,String _reason,int _statuscode,int _taskid) throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub hc_ResponseError (Response As HttpResponse, Re";
 //BA.debugLineNum = 45;BA.debugLine="If Response <> Null Then";
if (_response!= null) { 
 //BA.debugLineNum = 46;BA.debugLine="Try";
try { //BA.debugLineNum = 47;BA.debugLine="Log(Response.GetString(\"UTF8\"))";
anywheresoftware.b4a.keywords.Common.Log(_response.GetString("UTF8"));
 } 
       catch (Exception e5) {
			ba.setLastException(e5); //BA.debugLineNum = 49;BA.debugLine="Log(\"Failed to read error message.\")";
anywheresoftware.b4a.keywords.Common.Log("Failed to read error message.");
 };
 //BA.debugLineNum = 51;BA.debugLine="Response.Release";
_response.Release();
 };
 //BA.debugLineNum = 53;BA.debugLine="CompleteJob(TaskId, False, Reason)";
_completejob(_taskid,anywheresoftware.b4a.keywords.Common.False,_reason);
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responsesuccess(anywheresoftware.b4a.http.HttpClientWrapper.HttpResponeWrapper _response,int _taskid) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub hc_ResponseSuccess (Response As HttpResponse,";
 //BA.debugLineNum = 32;BA.debugLine="Response.GetAsynchronously(\"response\", File.OpenO";
_response.GetAsynchronously(ba,"response",(java.io.OutputStream)(anywheresoftware.b4a.keywords.Common.File.OpenOutput(_tempfolder,BA.NumberToString(_taskid),anywheresoftware.b4a.keywords.Common.False).getObject()),anywheresoftware.b4a.keywords.Common.True,_taskid);
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _initialize() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Initialize";
 //BA.debugLineNum = 10;BA.debugLine="If hc.IsInitialized = False Then";
if (_hc.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 12;BA.debugLine="TempFolder = File.DirTemp";
_tempfolder = anywheresoftware.b4a.keywords.Common.File.getDirTemp();
 //BA.debugLineNum = 13;BA.debugLine="hc.Initialize(\"hc\")";
_hc.Initialize("hc");
 //BA.debugLineNum = 14;BA.debugLine="TaskIdToJob.Initialize";
_taskidtojob.Initialize();
 };
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private hc As HttpClient";
_hc = new anywheresoftware.b4a.http.HttpClientWrapper();
 //BA.debugLineNum = 4;BA.debugLine="Private TaskIdToJob As Map";
_taskidtojob = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 5;BA.debugLine="Public TempFolder As String";
_tempfolder = "";
 //BA.debugLineNum = 6;BA.debugLine="Private taskCounter As Int";
_taskcounter = 0;
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public static String  _response_streamfinish(boolean _success,int _taskid) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub Response_StreamFinish (Success As Boolean, Tas";
 //BA.debugLineNum = 37;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 38;BA.debugLine="CompleteJob(TaskId, Success, \"\")";
_completejob(_taskid,_success,"");
 }else {
 //BA.debugLineNum = 40;BA.debugLine="CompleteJob(TaskId, Success, LastException.Messa";
_completejob(_taskid,_success,anywheresoftware.b4a.keywords.Common.LastException(ba).getMessage());
 };
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static int  _submitjob(b4j.example.httpjob _job) throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Public Sub SubmitJob(job As HttpJob) As Int";
 //BA.debugLineNum = 21;BA.debugLine="taskCounter = taskCounter + 1";
_taskcounter = (int) (_taskcounter+1);
 //BA.debugLineNum = 22;BA.debugLine="TaskIdToJob.Put(taskCounter, job)";
_taskidtojob.Put((Object)(_taskcounter),(Object)(_job));
 //BA.debugLineNum = 23;BA.debugLine="If job.Username <> \"\" And job.Password <> \"\" Then";
if ((_job._username /*String*/ ).equals("") == false && (_job._password /*String*/ ).equals("") == false) { 
 //BA.debugLineNum = 24;BA.debugLine="hc.ExecuteCredentials(job.GetRequest, taskCounte";
_hc.ExecuteCredentials(ba,_job._getrequest /*anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper*/ (),_taskcounter,_job._username /*String*/ ,_job._password /*String*/ );
 }else {
 //BA.debugLineNum = 26;BA.debugLine="hc.Execute(job.GetRequest, taskCounter)";
_hc.Execute(ba,_job._getrequest /*anywheresoftware.b4a.http.HttpClientWrapper.HttpUriRequestWrapper*/ (),_taskcounter);
 };
 //BA.debugLineNum = 28;BA.debugLine="Return taskCounter";
if (true) return _taskcounter;
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return 0;
}
}
