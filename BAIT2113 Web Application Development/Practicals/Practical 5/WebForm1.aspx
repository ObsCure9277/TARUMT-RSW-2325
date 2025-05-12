<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="P5.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100px;
        }
        .auto-style2 {
            width: 3px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table style="width:100%;">
                <tr>
                    <td class="auto-style1">Users</td>
                    <td class="auto-style2">:</td>
                    <td>
                        <asp:DropDownList ID="ddlUsers" runat="server">
                        </asp:DropDownList>
&nbsp;&nbsp;&nbsp;
                        <asp:Button ID="btnGetUsers" runat="server" OnClick="btnGetUsers_Click" Text="Get User" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style1">Create Role</td>
                    <td class="auto-style2">:</td>
                    <td>
                        <asp:TextBox ID="txtRole" runat="server" Height="22px"></asp:TextBox>
&nbsp;&nbsp;&nbsp;
                        <asp:Button ID="btnCreateRole" runat="server" OnClick="btnCreateRole_Click" Text="Create Role" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style1">Roles</td>
                    <td class="auto-style2">:</td>
                    <td>
                        <asp:DropDownList ID="ddlRoles" runat="server">
                        </asp:DropDownList>
&nbsp;&nbsp;
                        <asp:Button ID="btnGetRoles" runat="server" OnClick="btnGetRoles_Click" Text="Get Roles" />
&nbsp;&nbsp;
                        <asp:Button ID="btnAssign" runat="server" OnClick="btnAssign_Click" Text="Assign" />
&nbsp;&nbsp;
                        <asp:Button ID="btnVerify" runat="server" OnClick="btnVerify_Click" Text="Verify" />
                    </td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>
                        <asp:ListBox ID="lstUsers" runat="server"></asp:ListBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style1">&nbsp;</td>
                    <td class="auto-style2">&nbsp;</td>
                    <td>&nbsp;</td>
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
