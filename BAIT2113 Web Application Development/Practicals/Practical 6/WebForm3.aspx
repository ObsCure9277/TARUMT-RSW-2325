<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm3.aspx.cs" Inherits="P6.WebForm3" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 10px;
        }
        .auto-style2 {
            width: 82px;
        }
        .auto-style3 {
            width: 82px;
            height: 23px;
        }
        .auto-style4 {
            width: 10px;
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
                    <td class="auto-style2">Name</td>
                    <td class="auto-style1">:</td>
                    <td>
                        <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style2">Program</td>
                    <td class="auto-style1">:</td>
                    <td>
                        <asp:RadioButtonList ID="rblProgram" runat="server" RepeatDirection="Horizontal">
                            <asp:ListItem>RSD</asp:ListItem>
                            <asp:ListItem>RSW</asp:ListItem>
                            <asp:ListItem>RIS</asp:ListItem>
                        </asp:RadioButtonList>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style2">Language</td>
                    <td class="auto-style1">:</td>
                    <td>
                        <asp:DropDownList ID="ddlLanguage" runat="server">
                            <asp:ListItem>English</asp:ListItem>
                            <asp:ListItem>Malay</asp:ListItem>
                        </asp:DropDownList>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style2">&nbsp;</td>
                    <td class="auto-style1">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style3"></td>
                    <td class="auto-style4"></td>
                    <td class="auto-style5">
                        <asp:LinkButton ID="lBtnGo" runat="server" OnClick="lBtnGo_Click">Go</asp:LinkButton>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style3"></td>
                    <td class="auto-style4"></td>
                    <td class="auto-style5"></td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
