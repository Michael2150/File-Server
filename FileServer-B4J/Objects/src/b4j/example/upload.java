package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class upload extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.upload", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.upload.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.main _main = null;
public b4j.example.httputils2service _httputils2service = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
String _reqtype = "";
anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _tr = null;
String _name = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 10;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 11;BA.debugLine="If req.Method <> \"POST\" Then";
if ((_req.getMethod()).equals("POST") == false) { 
 //BA.debugLineNum = 12;BA.debugLine="resp.SendError(500, \"method not supported.\")";
_resp.SendError((int) (500),"method not supported.");
 //BA.debugLineNum = 13;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 17;BA.debugLine="Dim In As InputStream = req.InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
_in = _req.getInputStream();
 //BA.debugLineNum = 18;BA.debugLine="Dim reqType As String = req.GetParameter(\"type\")";
_reqtype = _req.GetParameter("type");
 //BA.debugLineNum = 19;BA.debugLine="If reqType = \"\" Then";
if ((_reqtype).equals("")) { 
 //BA.debugLineNum = 20;BA.debugLine="resp.SendError(500, \"Missing type parameter.\")";
_resp.SendError((int) (500),"Missing type parameter.");
 //BA.debugLineNum = 21;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 23;BA.debugLine="Select reqType";
switch (BA.switchObjectToInt(_reqtype,"text","file")) {
case 0: {
 //BA.debugLineNum = 25;BA.debugLine="Dim tr As TextReader";
_tr = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
 //BA.debugLineNum = 26;BA.debugLine="tr.Initialize(In)";
_tr.Initialize((java.io.InputStream)(_in.getObject()));
 //BA.debugLineNum = 27;BA.debugLine="Log(\"Received text message: \" & CRLF & tr.ReadA";
__c.Log("Received text message: "+__c.CRLF+_tr.ReadAll());
 //BA.debugLineNum = 28;BA.debugLine="resp.Write(\"Message received successfully.\")";
_resp.Write("Message received successfully.");
 break; }
case 1: {
 //BA.debugLineNum = 30;BA.debugLine="Dim name As String = req.GetParameter(\"name\")";
_name = _req.GetParameter("name");
 //BA.debugLineNum = 31;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Main.";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = __c.File.OpenOutput(_main._filesfolder /*String*/ ,_name,__c.False);
 //BA.debugLineNum = 32;BA.debugLine="File.Copy2(In, out)";
__c.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 33;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 34;BA.debugLine="Log(\"Received file: \" & name & \", size=\" & File";
__c.Log("Received file: "+_name+", size="+BA.NumberToString(__c.File.Size(_main._filesfolder /*String*/ ,_name)));
 //BA.debugLineNum = 35;BA.debugLine="resp.Write(\"File received successfully.\")";
_resp.Write("File received successfully.");
 break; }
}
;
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 6;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
