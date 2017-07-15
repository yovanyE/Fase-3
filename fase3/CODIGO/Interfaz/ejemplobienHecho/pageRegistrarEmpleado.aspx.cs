using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ejemplobienHecho
{
    public partial class pageRegistrarEmpleado : System.Web.UI.Page
    {
        wsBanco.BancoController control = new wsBanco.BancoController();
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        public void limpiarCampos()
        {
            txtCui.Text = "";
            txtNombre.Text = "";
            txtApellido.Text = "";
            txtDireccion.Text = "";
            txtphone.Text = "";
            txtAgencia.Text = "";
            //ddlTipo.ClearSelection();
            txtTipo.Text = "";
            txtLogin.Text = "";
            txtPass.Text = "";
        }
        public void dropLista()
        {
            //    ListItem tipo1 = new ListItem("Atencion al cliente", "1");
            //    ddlTipo.Items.Add(tipo1);
            //    ListItem tipo2 = new ListItem("Cajero", "2");
            //    ddlTipo.Items.Add(tipo2);
            //    ListItem tipo3 = new ListItem("Gerente", "3");
            //    ddlTipo.Items.Add(tipo3);

        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {

            if(control.registrarEmpleado(int.Parse(txtCui.Text), txtNombre.Text, txtApellido.Text, txtDireccion.Text, txtphone.Text, int.Parse(txtAgencia.Text),int.Parse(txtTipo.Text), txtLogin.Text, txtPass.Text) != null)
            {
                lblMen.Text = "Empleado registrado exitosamente";
            }else
            {
                lblMen.Text = "Debe llenar todos los campos";
            }
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            //dropLista();
            limpiarCampos();
        }

        protected void btnBuscar_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                wsBanco.empleado empleado = control.busquedaEmpleado(int.Parse(txtBuscar.Text));
                //dropLista();
                if (control.busquedaEmpleado(int.Parse(txtBuscar.Text)) != null)
                {
                    txtCui.Text = empleado.cui.ToString();
                    txtNombre.Text = empleado.nombre;
                    txtApellido.Text = empleado.apellidos;
                    txtDireccion.Text = empleado.direccion;
                    txtphone.Text = empleado.telefono;
                    txtAgencia.Text = empleado.idAgencia.ToString();
                    //ddlTipo.SelectedIndex = ddlTipo.Items.IndexOf(ddlTipo.Items.FindByText(empleado.idRol.ToString()));
                    txtTipo.Text = empleado.idRol.ToString();
                    txtLogin.Text = empleado.login;
                    txtPass.Text = empleado.password;

                    lblMen.Text = "Busqueda exitosa";
                }else
                {
                    lblMen.Text = "Cui del cliente no existe, debe registrarlo"; 
                }
            }catch
            {
                lblMen.Text = "Debe llenar el campo de busqueda";
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            try
            {
                wsBanco.empleado modificar = control.modificarEmpleado(int.Parse(txtCui.Text), txtNombre.Text, txtApellido.Text, txtDireccion.Text, txtphone.Text, int.Parse(txtAgencia.Text), int.Parse(txtTipo.Text), txtLogin.Text, txtPass.Text);
                if (control.modificarEmpleado(int.Parse(txtCui.Text), txtNombre.Text, txtApellido.Text, txtDireccion.Text, txtphone.Text, int.Parse(txtAgencia.Text), int.Parse(txtTipo.Text), txtLogin.Text, txtPass.Text) != null)
                {
                    lblMen.Text = "no se pudo modificar";
                }
                else
                {
                    limpiarCampos();
                    lblMen.Text = "modificacion exitosa";
                }
            }catch
            {
                lblMen.Text = "algun campo no esta lleno";
            }
        }

        protected void btnElimina_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                if (control.eliminarEmpleado(int.Parse(txtBuscar.Text)) != null)
                {
                    lblMen.Text = "No esta eliminando ningun registro";
                }
                else
                {
                    limpiarCampos();
                    lblMen.Text = "Registsro eliminado";
                }
            }
            catch
            {
                lblMen.Text = "Debe llenar los campos para eliminar";
            }
        }
    }
}