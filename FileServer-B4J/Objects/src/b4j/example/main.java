package b4j.example;


import anywheresoftware.b4a.BA;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) throws Exception{
        try {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            ba.raiseEvent(null, "appstart", (Object)args);
        } catch (Throwable t) {
			BA.printException(t, true);
		
        } finally {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program terminated (StartMessageLoop was not called).");
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static String _domain = "";
public static String _token = "";
public static anywheresoftware.b4a.objects.Timer _updateip = null;
public static anywheresoftware.b4j.object.ServerWrapper _srvr = null;
public static String _filesfolder = "";
public static b4j.example.httputils2service _httputils2service = null;
public static String  _appstart(String[] _args) throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 16;BA.debugLine="updateIp.Initialize(\"updateIp\", 10 * 60 * 1000) '";
_updateip.Initialize(ba,"updateIp",(long) (10*60*1000));
 //BA.debugLineNum = 17;BA.debugLine="updateIp.Enabled = True";
_updateip.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 18;BA.debugLine="UpdateIp_Tick";
_updateip_tick();
 //BA.debugLineNum = 19;BA.debugLine="srvr.Initialize(\"srvr\")";
_srvr.Initialize(ba,"srvr");
 //BA.debugLineNum = 20;BA.debugLine="srvr.Port = 54021";
_srvr.setPort((int) (54021));
 //BA.debugLineNum = 21;BA.debugLine="File.MakeDir(File.DirApp, filesFolder)";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirApp(),_filesfolder);
 //BA.debugLineNum = 22;BA.debugLine="srvr.AddHandler(\"/upload\", \"Upload\", False)";
_srvr.AddHandler("/upload","Upload",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 23;BA.debugLine="srvr.AddHandler(\"/test\", \"Test\", False)";
_srvr.AddHandler("/test","Test",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 24;BA.debugLine="srvr.Start";
_srvr.Start();
 //BA.debugLineNum = 25;BA.debugLine="Log(\"Server started\")";
anywheresoftware.b4a.keywords.Common.Log("Server started");
 //BA.debugLineNum = 26;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4j.example.httpjob _j) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub JobDone (j As HttpJob)";
 //BA.debugLineNum = 37;BA.debugLine="If j.Success = True Then";
if (_j._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 38;BA.debugLine="Log(\"Update DuckDNS: \" & j.GetString)";
anywheresoftware.b4a.keywords.Common.Log("Update DuckDNS: "+_j._getstring /*String*/ ());
 }else {
 //BA.debugLineNum = 40;BA.debugLine="Log(\"Error updating Duck DNS: \" & j.ErrorMessage";
anywheresoftware.b4a.keywords.Common.Log("Error updating Duck DNS: "+_j._errormessage /*String*/ );
 };
 //BA.debugLineNum = 42;BA.debugLine="j.Release";
_j._release /*String*/ ();
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private domain As String = \"dispatchit\"";
_domain = "dispatchit";
 //BA.debugLineNum = 9;BA.debugLine="Private token As String = \"b1941a0d-33a7-43ef-816";
_token = "b1941a0d-33a7-43ef-8167-0660d4a24a87";
 //BA.debugLineNum = 10;BA.debugLine="Private updateIp As Timer";
_updateip = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 11;BA.debugLine="Private srvr As Server";
_srvr = new anywheresoftware.b4j.object.ServerWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Public filesFolder As String = \"uploaded\"";
_filesfolder = "uploaded";
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public static String  _updateip_tick() throws Exception{
b4j.example.httpjob _j = null;
 //BA.debugLineNum = 29;BA.debugLine="Sub UpdateIp_Tick";
 //BA.debugLineNum = 30;BA.debugLine="Dim j As HttpJob";
_j = new b4j.example.httpjob();
 //BA.debugLineNum = 31;BA.debugLine="j.Initialize(\"j\", Me)";
_j._initialize /*String*/ (ba,"j",main.getObject());
 //BA.debugLineNum = 32;BA.debugLine="j.Download2(\"http://www.duckdns.org/update\", Arra";
_j._download2 /*String*/ ("http://www.duckdns.org/update",new String[]{"domains",_domain,"token",_token,"ip",""});
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
}
