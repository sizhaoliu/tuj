// ============================================================================
//
// Copyright (C) 2006-2007 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.dataprofiler.core.ui.wizard.analysis;

import java.util.Properties;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.talend.cwm.management.connection.ConnectionParameters;
import org.talend.dataprofiler.core.CorePlugin;
import org.talend.dataprofiler.core.ImageLib;
import org.talend.dataprofiler.core.ui.wizard.PropertiesWizardPage;
import org.talend.dataquality.analysis.AnalysisType;
import org.talend.dq.analysis.AnalysisBuilder;

/**
 * @author zqin
 *
 */
public class CreateNewAnalysisWizard extends Wizard{
    
    private IWorkbench workbench;

    private Object selection;
    
    private boolean creation;
    
    private PropertiesWizardPage propertiesWizardPage;

    private ConnectionParameters connectionParams;
    
    private AnalysisWizardPageStep0 page0;
    
    private AnalysisWizardPageStep1 page1;

    
    public CreateNewAnalysisWizard(IWorkbench workbench, boolean creation, IStructuredSelection selection,
            String[] existingNames) {
        this.creation = creation;
        this.init(workbench, selection);
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        
        
        return true;
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        // TODO Auto-generated method stub
        this.workbench = workbench;
        this.selection = selection;
        if (creation) {
            connectionParams = new ConnectionParameters();
            connectionParams.setParameters(new Properties());
        } else {
            //get existing connectionParameters
        }
        
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    @Override
    public void addPages() {

        setWindowTitle("Create New Analysis");
        setDefaultPageImageDescriptor(ImageLib.getImageDescriptor(ImageLib.REFRESH_IMAGE));
        
        page0 = new AnalysisWizardPageStep0(connectionParams);
        page1 = new AnalysisWizardPageStep1(connectionParams, null, false, true); 
        
        addPage(page0);
        addPage(page1);
        
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#canFinish()
     */
    @Override
    public boolean canFinish() {
        if (this.getContainer().getCurrentPage() != page1) {
            return false;
        }
        return super.canFinish();
    }
}
