package project;

public class DatabasePath {
    private int idWarehouse = 1;
    private int idDepartment = 1;
    private int idCommodity = 1;
    private int idDesigner = 1;
    private int idDuty = 1;
    private int idExposition = 1;
    private int idManager = 1;
    private int idOpinion = 1;
    private int idVacation = 1;
    private int idWorker = 1;
    private static final DatabasePath instance = new DatabasePath();

    private DatabasePath() {}

    public static DatabasePath getInstance() {
        return instance;
    }

    public int getIdWarehouse() {
        return this.idWarehouse;
    }

    public int getIdDepartment() {
        return this.idDepartment;
    }

    public int getIdCommodity() {
        return this.idCommodity;
    }

    public int getIdDesigner() {
        return this.idDesigner;
    }

    public int getIdDuty() {
        return this.idDuty;
    }

    public int getIdExposition() {
        return this.idExposition;
    }

    public int getIdManager() {
        return this.idManager;
    }

    public int getIdOpinion() {
        return this.idOpinion;
    }

    public int getIdVacation() {
        return this.idVacation;
    }

    public int getIdWorker() {
        return this.idWorker;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public void setIdCommodity(int idCommodity) {
        this.idCommodity = idCommodity;
    }

    public void setIdDesigner(int idDesigner) {
        this.idDesigner = idDesigner;
    }

    public void setIdDuty(int idDuty) {
        this.idDuty = idDuty;
    }

    public void setIdExposition(int idExposition) {
        this.idExposition = idExposition;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public void setIdOpinion(int idOpinion) {
        this.idOpinion = idOpinion;
    }

    public void setIdVacation(int idVacation) {
        this.idVacation = idVacation;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }
}
