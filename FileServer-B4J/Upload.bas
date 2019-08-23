B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=1.45
@EndOfDesignText@
'Class module
Sub Class_Globals
	
End Sub

Public Sub Initialize

End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	If req.Method <> "POST" Then
		resp.SendError(500, "method not supported.")
		Return
	End If
	'we need to call req.InputStream before calling GetParameter.
	'Otherwise the stream will be read internally (as the parameter might be in the post body).
	Dim In As InputStream = req.InputStream
	Dim reqType As String = req.GetParameter("type")
	If reqType = "" Then
		resp.SendError(500, "Missing type parameter.")
		Return
	End If
	Select reqType
		Case "text"
			Dim tr As TextReader
			tr.Initialize(In)
			Log("Received text message: " & CRLF & tr.ReadAll)
			resp.Write("Message received successfully.")
		Case "file"
			Dim name As String = req.GetParameter("name")
			Dim out As OutputStream = File.OpenOutput(Main.filesFolder, name, False)
			File.Copy2(In, out)
			out.Close
			Log("Received file: " & name & ", size=" & File.Size(Main.filesFolder, name))
			resp.Write("File received successfully.")
	End Select
End Sub