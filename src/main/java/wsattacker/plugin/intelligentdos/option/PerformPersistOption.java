/**
 * WS-Attacker - A Modular Web Services Penetration Testing Framework Copyright
 * (C) 2013 Christian Altmeier
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package wsattacker.plugin.intelligentdos.option;

import org.apache.commons.lang3.StringUtils;
import wsattacker.gui.component.pluginconfiguration.composition.OptionGUI;
import wsattacker.main.composition.plugin.option.AbstractOption;
import wsattacker.plugin.intelligentdos.ui.option.PerformPersistOptionGUI_NB;

/**
 * @author Christian Altmeier
 */
public class PerformPersistOption
    extends AbstractOption
{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    public static final String PROP_PERSIST = "persist";

    public static final String PROP_BASEDIR = "baseDir";

    private boolean persist;

    private String baseDir;

    public PerformPersistOption( String name, String description, String baseDir )
    {
        super( name, description );
        if ( StringUtils.isEmpty( baseDir ) )
        {
            baseDir = "";
            persist = false;
        }
        else
        {
            this.persist = true;
            this.baseDir = baseDir;
        }
    }

    public boolean isPersist()
    {
        return persist;
    }

    public void setPersist( boolean persist )
    {
        this.persist = persist;
    }

    public String getBaseDir()
    {
        return baseDir;
    }

    public void setBaseDir( String baseDir )
    {
        if ( isValid( baseDir ) )
        {
            String oldBaseDir = this.baseDir;
            this.baseDir = baseDir;
            firePropertyChange( PROP_BASEDIR, oldBaseDir, baseDir );
        }
        else
        {
            throw new IllegalArgumentException( String.format( "isValid(\"%s\") returned false", baseDir ) );
        }
    }

    @Override
    public boolean isValid( String value )
    {
        return StringUtils.isNotEmpty( value );
    }

    @Override
    public void parseValue( String value )
    {
    }

    @Override
    public String getValueAsString()
    {
        return null;
    }

    @Override
    public OptionGUI createOptionGUI()
    {
        return new PerformPersistOptionGUI_NB( this );
    }

}
