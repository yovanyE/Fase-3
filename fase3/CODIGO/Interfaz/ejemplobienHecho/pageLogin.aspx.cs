using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class page1Cargable : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {


        }

        protected void btnIngresar_Click(object sender, EventArgs e)
        {
            try
            {
                if (control.validar(txtUsuario.Text, txtPass.Text) != null)
                {
                    Response.Redirect("~/pageChequeCliente.aspx");
                }
                wsBanco.empleado users = control.loginEmpleado(txtUsuario.Text, txtPass.Text);
                if (users.idRol == 1)
                {
                    Response.Redirect("~/pageRegistroClientei.aspx");
                }
                else if (users.idRol == 2)
                {
                    Response.Redirect("~/pageRegistroClientei.aspx");
                }
                else if (users.idRol == 3)
                {
                    Response.Redirect("~/pageRegistrarEmpleado.aspx");
                }
                else
                {
                    Response.Redirect("~/pageLogin.aspx");

                }
            }catch
            {
                lblMensaje.Text = "Debe llenar los campos";
            }
            
        }
    }
}