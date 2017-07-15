using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pagePatrocinadorR : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void limpiarCampos()
        {
            txtNombre.Text = "";
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
                if (control.registrarProveedor(txtNombre.Text) != null)
                {
                    limpiarCampos();
                    lblMen.Text = "Proveedor registrado exitosamente";
                }
                else
                {
                    lblMen.Text = "Debe llenar todos los campos";
                }
            }
            catch
            {
                lblMen.Text = "tipo de dato incorrecto";
            }
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            limpiarCampos();
        }

        protected void btnBuscar_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                wsBanco.patrocinador patrocina = control.buscarPatrocinador(txtBuscar.Text);
                if (control.buscarPatrocinador(txtBuscar.Text) != null)
                {
                    txtNombre.Text = patrocina.nombre;
                    lblMen.Text = "busqueda exitosa";
                }
                else
                {
                    lblMen.Text = "nombre de proveedor no existe, debe registrarlo";
                }
            }catch
            {
                lblMen.Text = "Debe llenar el campo de busqueda";
            }
        }

        protected void btnReporte_Click(object sender, ImageClickEventArgs e)
        {

        }
    }
}