Type=Class
Version=1.45
B4J=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	resp.ContentType = "text/html"
	resp.Write("Your ip address: ").Write(req.RemoteAddress).Write("<br/>")
End Sub