/**
 * Get correct exercise solution 'div' within element indicated by parameter id.
 *
 * @param id String id of problem
 * @param whichSolution Number determines which of the potentially multiple solutions is the correct one
 * @return nsIDOMElement 'div' of solution
 */
function getExerciseSolution(id,whichSolution) {
    descendantDivs = document.getElementById(id).getElementsByTagName("div");
    solutionDivs = new Array();
    for (i = 0, j = 0; i < descendantDivs.length; i++) {
	if (descendantDivs[i].className == 'solution') {
	    solutionDivs[j]=descendantDivs[i];
	    j++;
	}
    }
    return solutionDivs[whichSolution - 1];
}

/**
 * Get correct solution button 'div' within element indicated by parameter id.
 *
 * @param id String id of problem
 * @param whichSolution Number determines which of the potentially multiple solutions is the correct one
 * @param whichAction determines whether the solution is being hidden or shown
 * @return nsIDOMElement 'span' of solution button
 */
function getSolutionButton(id,whichSolution,whichAction) {
    descendantSpans = document.getElementById(id).getElementsByTagName("span");
    buttonSpans = new Array();
    for (i = 0, j = 0; i < descendantSpans.length; i++) {
	if (descendantSpans[i].className == 'solution-toggle') {
	    buttonSpans[j]=descendantSpans[i];
	    j++;
	}
    }
    if (whichAction == 'show') {
        return buttonSpans[(whichSolution - 1) * 2]; // there are 2 "buttons" for each solution. take the first of each pair.
    } else {
        return buttonSpans[(whichSolution - 1) * 2 + 1]; // there are 2 "buttons" for each solution.  take the second of each pair.
    } 
}

/**
 * Show or hide the solution of problem indicated by id.
 *
 * @param id String id of problem
 * @param whichSolution Number determines which of the potentially multiple solutions is the correct one
 */
function toggleSolution(id,whichSolution) {
    // If showing the solution
    if (getExerciseSolution(id,whichSolution).style.display != 'block') {
        getExerciseSolution(id,whichSolution).style.display="block";
        getSolutionButton(id,whichSolution,"show").style.display="none";
        getSolutionButton(id,whichSolution,"hide").style.display="inline";
    // If hiding the solution
    } else {
        getExerciseSolution(id,whichSolution).style.display="none";
        getSolutionButton(id,whichSolution,"show").style.display="inline";
        getSolutionButton(id,whichSolution,"hide").style.display="none";
    }
}

