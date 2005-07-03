package org.objectstyle.wolips.wodclipse.editors;

import org.eclipse.jdt.internal.ui.IJavaHelpContextIds;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.objectstyle.wolips.wodclipse.WodclipsePlugin;

public class WODEditor extends TextEditor {
  public WODEditor() {
    setSourceViewerConfiguration(new WODSourceViewerConfiguration(this));
  }

  protected void initializeKeyBindingScopes() {
    setKeyBindingScopes(new String[] { "org.objectstyle.wolips.wodclipse.wodEditorScope" });
  }

  protected ISourceViewer createSourceViewer(Composite _parent, IVerticalRuler _verticalRuler, int _styles) {
    return super.createSourceViewer(_parent, _verticalRuler, _styles);
  }

  protected void createActions() {
    super.createActions();
    ContentAssistAction action = new ContentAssistAction(WodclipsePlugin.getDefault().getResourceBundle(), "ContentAssistProposal.", this); //$NON-NLS-1$
    action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
    setAction("ContentAssistProposal", action);
    markAsStateDependentAction("ContentAssistProposal", true);
    PlatformUI.getWorkbench().getHelpSystem().setHelp(action, IJavaHelpContextIds.CONTENT_ASSIST_ACTION);
  }
}
