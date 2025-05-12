<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="LoginPage.aspx.cs" Inherits="P5.LoginPage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Login ID="Login1" runat="server" DestinationPageUrl="~/HomePage.aspx">
            </asp:Login>
            <br />
            <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/Registration.aspx">Registration</asp:HyperLink>
            <br />
        </div>
    </form>
</body>
</html>
