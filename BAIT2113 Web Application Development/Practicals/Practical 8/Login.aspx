<%@ Page Language="C#" MasterPageFile="~/03_DefaultMaster.master" AutoEventWireup="true" Inherits="Login" Title="Untitled Page" Codebehind="Login.aspx.cs" %>
<%@ Register Src="~/LoginControl.ascx" TagPrefix="Any" TagName="BAny" %>
<%@ Register Src="~/Labels.ascx" TagPrefix="A" TagName="B" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="leftColumn">
    <p align="center" style="margin-top:20px;"> 
    
    <!-- Place your LoginControl here -->
    <Any:BAny ID="ctrlLogin" runat="server" />
        <A:B ID="ctrlA" runat="server" />
    
</div>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentAd" Runat="Server">
</asp:Content>

