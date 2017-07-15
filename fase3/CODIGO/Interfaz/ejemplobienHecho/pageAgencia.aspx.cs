using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pageAgencia : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();

        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void limpiarCampos()
        {
            txtNombre.Text = "";
            txtDireccion.Text = "";
        }
        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            try { 
            wsBanco.agencia age = control.buscarAgencia(txtBuscar.Text);

            if (control.busquedaClienteindividual(int.Parse(txtBuscar.Text)) != null)
            {
                    txtNombre.Text = age.nombre;
                    txtDireccion.Text = age.direccion;
               

                lblMen.Text = "busqueda exitosa";
            }
            else
            {
                lblMen.Text = "nombre de agencia no existe, desea registrarlo?";
            }
        } catch
            {
                lblMen.Text = "Debe llenar el campo de busqueda";
            }
}

        protected void btnModifica_Click(object sender, EventArgs e)
        {
            try
            {
                wsBanco.agencia modificar = control.modificarAgencia(txtNombre.Text,txtDireccion.Text);
                if (control.modificarAgencia(txtNombre.Text,txtDireccion.Text) != null)
                {
                    lblMen.Text = "Debe llenar todos los campos para modificar";
                }
                else
                {
                    limpiarCampos();
                    lblMen.Text = "modificacion exitosa";
                }
            }
            catch
            {
                lblMen.Text = "algun campo no esta lleno";
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
                if (control.registrarAgencia(txtNombre.Text,txtDireccion.Text) != null)
                {
                    lblMen.Text = "registro exitoso";
                    limpiarCampos();
                }
                else
                {
                    lblMen.Text = "Debe llenar todos los campos";
                }
            }
            catch
            {
                lblMen.Text = "campo no valido";
            }

        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            limpiarCampos();
        }

        protected void btnElimina_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                if ((control.eliminarAgencia(txtBuscar.Text)) != null)
                {
                    lblMen.Text = "DEBE LLENAR EL CAMPO DE BUSQUEDA";
                }
                else
                {
                    lblMen.Text = "REGISTRO ELIMINADO";
                    limpiarCampos();
                }
            }
            catch
            {
                lblMen.Text = "DEBE LLENAR EL CAMPO DE BUSQUEDA";
            }
        }
    }
}