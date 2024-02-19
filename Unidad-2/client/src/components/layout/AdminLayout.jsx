import React from 'react'
import { Outlet } from 'react-router-dom'

const AdminLayout = () => {
    return (
        <>
            <header>
                NavBar
            </header>
            <aside>
                SideBar
            </aside>
            <main>
                <Outlet />
            </main>
        </>
    )
}

export default AdminLayout