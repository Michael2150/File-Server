﻿B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=1.45
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