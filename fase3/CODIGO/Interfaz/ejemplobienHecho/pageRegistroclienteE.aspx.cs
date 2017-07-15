using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pageRegistroclienteE : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            control.registrarClienteEmpresa(txtNombre.Text, txtDireccion.Text, txtTelefono.Text, txtLogin.Text, txtPassword.Text);
        }
    }
}