import React, { useContext } from "react";
import AuthContext from '../../config/context/auth-context'
import { Link, Outlet } from "react-router-dom";
import { Avatar, Dropdown, Navbar } from 'flowbite-react';
import { Sidebar } from 'flowbite-react';
import { HiArrowSmRight, HiChartPie, HiInbox, HiShoppingBag, HiTable, HiUser } from 'react-icons/hi';
import '../../assets/styles/AdminLayout.css'

const AdminLayout = () => {
  // Método para cerrar sesión
  const { dispatch } = useContext(AuthContext);
  const handleLogout = () => {
    dispatch({ type: "SIGNOUT" })
  }
  return (
    <>
      <header>
        <Navbar fluid rounded style={{ background: '#b88e34' }}>
          <Navbar.Brand href="https://flowbite-react.com">
            <span className="self-center whitespace-nowrap text-xl font-semibold dark:text-white" style={{ color: 'white' }}>Flowbite React</span>
          </Navbar.Brand>
          <div className="flex md:order-2">
            <Dropdown
              arrowIcon={false}
              inline
            >
              <Dropdown.Header>
                <span className="block text-sm">Bonnie Green</span>
                <span className="block truncate text-sm font-medium">name@flowbite.com</span>
              </Dropdown.Header>
              <Dropdown.Item>Dashboard</Dropdown.Item>
              <Dropdown.Item>Settings</Dropdown.Item>
              <Dropdown.Item>Earnings</Dropdown.Item>
              <Dropdown.Divider />
              <Dropdown.Item>Sign out</Dropdown.Item>
            </Dropdown>
            <Navbar.Toggle />
          </div>
          <Navbar.Collapse>
            <Navbar.Link className="linkNav" href="#" active style={{ color: 'white' }}>
              Home
            </Navbar.Link>
            <Navbar.Link className="linkNav" href="#" style={{ color: 'white' }}>About</Navbar.Link>
            <Navbar.Link className="linkNav" href="#" style={{ color: 'white' }}>Services</Navbar.Link>
            <Navbar.Link className="linkNav" href="#" style={{ color: 'white' }}>Pricing</Navbar.Link>
            <Navbar.Link className="linkNav" href="#" style={{ color: 'white' }}>Contact</Navbar.Link>
          </Navbar.Collapse>
        </Navbar>
      </header>
      <main className="flex" style={{ height: '100%' }}>
        <aside>
          <Sidebar aria-label="Sidebar with multi-level dropdown example">
            <Sidebar.Items>
              <Sidebar.ItemGroup>
                <li>
                  <Link to={"dashboard"}
                    className="flex items-center justify-center rounded-lg p-2 text-base font-normal text-gray-900 hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700">
                    <HiChartPie className="h-6 w-6 flex-shrink-0 text-gray-500 transition duration-75 group-hover:text-gray-900 dark:text-gray-400 dark:group-hover:text-white"></HiChartPie>
                    <span className="px-3 flex-1 whitespace-nowrap">
                      Dashboard
                    </span>
                  </Link>
                </li>
                <li>
                  <Link to={"users"}
                    className="flex items-center justify-center rounded-lg p-2 text-base font-normal text-gray-900 hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700">
                    <HiUser className="h-6 w-6 flex-shrink-0 text-gray-500 transition duration-75 group-hover:text-gray-900 dark:text-gray-400 dark:group-hover:text-white"></HiUser>
                    <span className="px-3 flex-1 whitespace-nowrap">
                      Usuarios
                    </span>
                  </Link>
                </li>
                <li>
                  <Link to={"products"}
                    className="flex items-center justify-center rounded-lg p-2 text-base font-normal text-gray-900 hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700">
                    <HiShoppingBag className="h-6 w-6 flex-shrink-0 text-gray-500 transition duration-75 group-hover:text-gray-900 dark:text-gray-400 dark:group-hover:text-white"></HiShoppingBag>
                    <span className="px-3 flex-1 whitespace-nowrap">
                      Productos
                    </span>
                  </Link>
                </li>
                <Sidebar.Item as={Link} href="users" icon={HiInbox}>
                  Inbox
                </Sidebar.Item>
                <Sidebar.Item href="#" icon={HiArrowSmRight}>
                  Sign In
                </Sidebar.Item>
                <Sidebar.Item href="#" icon={HiTable} onClick={handleLogout}>
                  Sign Up
                </Sidebar.Item>
              </Sidebar.ItemGroup>
            </Sidebar.Items>
          </Sidebar>
        </aside>
        <section>
          <Outlet />
        </section>
      </main>
    </>
  );
};

export default AdminLayout;
