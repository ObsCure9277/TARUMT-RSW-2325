<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="P1.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 74px;
        }
        .auto-style2 {
            width: 18px;
        }
        .auto-style3 {
            width: 74px;
            height: 23px;
        }
        .auto-style4 {
            width: 18px;
            height: 23px;
        }
        .auto-style5 {
            height: 23px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table style="width:100%;">
                <tr>
                    <td class="auto-style1">Name</td>
                    <td class="auto-style2">:</td>
                    <td>
                        <asp:TextBox ID="txtName" runat="server" ></asp:TextBox>
&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style1">Program</td>
                    <td class="auto-style2">:</td>
                    <td>
                        <asp:DropDownList ID="ddlProgram" runat="server">
                            <asp:ListItem Value="SW">Software Engineering</asp:ListItem>
                            <asp:ListItem Value="IS">Information Security</asp:ListItem>
                        </asp:DropDownList>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>
                        <asp:Label ID="lblDisplay" runat="server"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>
                        <asp:Button ID="btnSubmit" runat="server" BackColor="White" OnClick="btnSubmit_Click" Text="Submit" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>
                        <asp:Button ID="btnTest" runat="server" OnClick="btnTest_Click" Text="Test" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>Server Control - runat=&quot;server&quot; (Button)</td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>Properties</td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>Method (verb)</td>
                </tr>
                <tr>
                    <td class="auto-style3"></td>
                    <td class="auto-style4"></td>
                    <td class="auto-style5">Event - what external forces (Users, other systems) can do on the control</td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
